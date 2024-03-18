package by.it_academy.jd2.messages.controller.http;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.api.ILoginService;
import by.it_academy.jd2.messages.service.dto.LoginDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private final static String LOGIN_PARAM_NAME="login";
    private final static String PASSWORD_PARAM_NAME="password";
    private final ILoginService loginService=ServiceFactory.getLoginService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter(LOGIN_PARAM_NAME);
        String password=req.getParameter(PASSWORD_PARAM_NAME);

        LoginDTO loginDTO=new LoginDTO(login,password);
        PrintWriter writer=resp.getWriter();

        UserDTO userDTO=this.loginService.login(loginDTO);
        HttpSession session = req.getSession();
        session.setAttribute("user", userDTO);
    }
}
