package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.UserDTOBuilder;
import by.it_academy.jd2.messages.dao.api.IUserDao;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.dto.UserRole;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserDao userDao;
    private final IStatisticsService statisticsService;

    public UserService(IUserDao userDao,IStatisticsService statisticsService) {
        this.userDao = userDao;
        this.statisticsService=statisticsService;
    }

    @Override
    public void create(UserDTO userDTO) {
        if (userDTO.getRole()==null){
            throw new IllegalArgumentException("Не задана роль пользователя");
        }

        if (userDTO.getLogin()==null||userDTO.getLogin().isBlank()){
            throw new IllegalArgumentException("Не задан логин пользователя");
        }

        if (userDTO.getPassword()==null||userDTO.getPassword().isBlank()){
            throw new IllegalArgumentException("Не задан пароль пользователя");
        }

        if (userDTO.getNames()==null){
            throw new IllegalArgumentException("Не указано имя пользователя");
        }

        for (String name: userDTO.getNames()) {
            if(name.isBlank()){
                throw new IllegalArgumentException("Не указано имя пользователя");
            }
        }

        if (userDTO.getBirthday()==null){
            throw new IllegalArgumentException("Не указана дата рождения пользователя");
        }

        if (userDTO.getRegistration()==null){
            throw new IllegalArgumentException("Не указана дата регистрации пользователя");
        }

        Optional<UserDTO> userByLogin=userDao.getByLogin(userDTO.getLogin());

        if (userByLogin.isPresent()){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }

        this.userDao.create(userDTO);
        statisticsService.addUser();
    }

    @Override
    public void create(RegistrationUserDTO registrationUserDTO) {
        UserDTO userDTO=UserDTOBuilder.builder().setLogin(registrationUserDTO.getLogin())
                .setPassword(registrationUserDTO.getPassword())
                .setNames(registrationUserDTO.getNames())
                .setBirthday(registrationUserDTO.getBirthday())
                .setRole(UserRole.USER)
                .setRegistration(LocalDateTime.now())
                .build();

        create(userDTO);
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return this.userDao.getByLogin(login);
    }
}
