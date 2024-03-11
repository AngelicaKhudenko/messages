package by.it_academy.jd2.messages.controller.http;

import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final static String LOGIN_PARAM_NAME="login";
    private final static String PASSWORD_PARAM_NAME="password";
    private final static String NAMES_PARAM_NAME="names";
    private final static String BIRTH_PARAM_NAME="birth";

    private final IUserService userService=ServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login=req.getParameter(LOGIN_PARAM_NAME);
        String password=req.getParameter(PASSWORD_PARAM_NAME);

        String names=req.getParameter(NAMES_PARAM_NAME);
        String dateOfBirth=req.getParameter(BIRTH_PARAM_NAME);

        boolean savingResult=userService.save(login,password,names,dateOfBirth);
        PrintWriter writer=resp.getWriter();
        if (savingResult){
            writer.write("<p>"+"Регистрация прошла успешно"+"</p");
        } else {
            writer.write("<p>"+"Пользователь с таким логином уже есть"+"</p");
        }
    }
}
