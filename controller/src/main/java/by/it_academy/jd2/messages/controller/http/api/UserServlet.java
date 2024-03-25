package by.it_academy.jd2.messages.controller.http.api;

import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebServlet(urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {
    private final static String LOGIN_PARAM_NAME="login";
    private final static String PASSWORD_PARAM_NAME="password";
    private final static String NAMES_PARAM_NAME="names";
    private final static String BIRTH_PARAM_NAME="birth";

    private final IUserService userService=ServiceFactory.getUserService();
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        String login=req.getParameter(LOGIN_PARAM_NAME);
        String password=req.getParameter(PASSWORD_PARAM_NAME);

        String []names=req.getParameter(NAMES_PARAM_NAME).trim().split(" +");
        String birthDayRaw=req.getParameter(BIRTH_PARAM_NAME);

        LocalDate birthDay;

        try {
            birthDay = LocalDate.parse(birthDayRaw, formatter);
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException("Ошибка при чтении даты. Введите дату в формате ГГГГ-ММ-ДД");
        }

        RegistrationUserDTO user=new RegistrationUserDTO(login,password,names,birthDay);

        userService.create(user);

        resp.setStatus(201);
    }
}
