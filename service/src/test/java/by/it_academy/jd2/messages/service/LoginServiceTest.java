package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.api.ILoginService;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.LoginDTO;
import by.it_academy.jd2.messages.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoginServiceTest {
    @Test
    @DisplayName("Проверка, зарегистрирован ли пользователь в системе")
    public void testOnLogging(){
        IUserService userService=ServiceFactory.getUserService();
        ILoginService loginService=ServiceFactory.getLoginService();

        String login="ivanova";
        String password="otodnogodovosmi";
        String []names="Иванова Светлана Андреевна".trim().split(" +");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday=LocalDate.parse("11-03-1999",formatter);

        RegistrationUserDTO registrationUserDTO=new RegistrationUserDTO(login,password,names,birthday);
        userService.create(registrationUserDTO);

        LoginDTO loginDTO=new LoginDTO(login,password);

        UserDTO user=loginService.login(loginDTO);

        Assertions.assertEquals(user.getNames(),names);
    }
}
