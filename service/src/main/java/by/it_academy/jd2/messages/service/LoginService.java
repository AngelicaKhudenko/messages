package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.api.ILoginService;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.LoginDTO;

import java.util.Optional;

public class LoginService implements ILoginService {
    private final IUserService userService;

    public LoginService(IUserService userService) {
        this.userService = userService;
    }

    private static final String WRONG_lOGIN_OR_PASSWORD="Введен неверный логин или пароль";

    @Override
    public UserDTO login(LoginDTO loginDTO) {
        Optional<UserDTO> optional = this.userService.getByLogin(loginDTO.getLogin());

        if(optional.isEmpty()){
            throw new IllegalArgumentException(WRONG_lOGIN_OR_PASSWORD);
        }

        UserDTO user=optional.get();
        if(!user.getPassword().equals(loginDTO.getPassword())){
            throw new IllegalArgumentException(WRONG_lOGIN_OR_PASSWORD);
        }

        return user;
    }
}
