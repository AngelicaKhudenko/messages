package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.dto.UserDTOBuilder;
import by.it_academy.jd2.messages.core.dto.UserRole;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class UserServiceTest {
    @Test
    @DisplayName("Тестирование на регистрацию и проверку наличия пользователя в системе")
    public void testOnCreatingUserAndChecking(){
        IUserService userService=ServiceFactory.getUserService();

        String login="ivanova_sveta";
        String password="otodnogodovosmi";
        String []names="Иванова Светлана Андреевна".trim().split(" +");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday=LocalDate.parse("11-03-1999",formatter);

        RegistrationUserDTO registrationUserDTO=new RegistrationUserDTO(login,password, names,birthday);

        userService.create(registrationUserDTO);

        Optional<UserDTO> optional=userService.getByLogin(login);
        if (optional.isPresent()){
            Assertions.assertEquals(optional.get().getNames(),names);
        }
    }

    @Test
    @DisplayName("Тестирование на регистрацию и проверку наличия в системе администратора")
    public void testOnCreatingAdminAndChecking(){
        IUserService userService=ServiceFactory.getUserService();

        String login="admin";
        String password="admin_password";
        String []names="Главный Администратор Приложения".trim().split(" +");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday=LocalDate.parse("15-03-1980",formatter);

        UserDTO userDTO=UserDTOBuilder.builder()
                .setLogin(login)
                .setPassword(password)
                .setNames(names)
                .setBirthday(birthday)
                .setRegistration(LocalDateTime.now())
                .setRole(UserRole.ADMIN).build();

        userService.create(userDTO);

        Optional<UserDTO> optional=userService.getByLogin(login);
        if (optional.isPresent()){
            Assertions.assertEquals(optional.get().getRole(),UserRole.ADMIN);
        }
    }
}
