package by.it_academy.jd2.messages.controller.http.ui.admin;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.dto.LoginDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatServlet extends HttpServlet {
    private final IStatisticsService statisticsService= ServiceFactory.getStatisticsService();
    private static final String AUTHORIZATION_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if (session.isNew()) {
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        UserDTO user= SessionUtils.giveUser(session);
        LoginDTO loginDTO=new LoginDTO(user.getLogin(),user.getPassword());

        StatisticsDTO statisticsDTO=statisticsService.get(loginDTO);
        req.setAttribute("statistics",statisticsDTO);

        req.getRequestDispatcher("/ui/admin/stat.jsp").forward(req,resp);
    }
}
