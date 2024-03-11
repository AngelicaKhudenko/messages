package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.service.api.ILoginService;
import by.it_academy.jd2.messages.service.api.IUserService;

public class LoginService implements ILoginService {
    private final IUserService userService;

    public LoginService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean checkUser(String login, String password) throws IllegalArgumentException{
        if (login==null||password==null){
            throw new IllegalArgumentException("Переданы некорректные значения. Заполните все поля");
        }

        return userService.checkUser(login,password);
    }
}
