package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.dto.UserRole;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.dao.api.IStatisticsDao;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.LoginDTO;

import java.util.Optional;

public class StatisticsService implements IStatisticsService {
    private final IStatisticsDao statisticsDao;
    private final IUserService userService;

    public StatisticsService(IStatisticsDao statisticsDao, IUserService userService){
        this.statisticsDao=statisticsDao;
        this.userService=userService;
    }
    @Override
    public StatisticsDTO get(LoginDTO loginDTO) throws UnauthorizedException {
        Optional<UserDTO> userByLogin=userService.getByLogin(loginDTO.getLogin());
        if (userByLogin.isEmpty()){
            throw new IllegalArgumentException("Пользователя с таким логином не существует");
        }

        UserDTO user=userByLogin.get();

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new IllegalArgumentException("Пароль не верный");
        }

        if (!UserRole.ADMIN.equals(user.getRole())){
            throw new UnauthorizedException("Вход запрещен");
        }

        return statisticsDao.get();
    }

    @Override
    public void addMessage() {
        statisticsDao.addMessage();
    }

    @Override
    public void addUser() {
        statisticsDao.addUser();
    }
    @Override
    public void addActiveUser() {
        statisticsDao.addActiveUser();
    }

    @Override
    public void removeMessage() {
        statisticsDao.removeMessage();
    }

    @Override
    public void removeUser() {
        statisticsDao.removeUser();
    }

    @Override
    public void removeActiveUser() {
        statisticsDao.removeActiveUser();
    }
}
