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

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatServlet extends HttpServlet {
    private final IStatisticsService statisticsService= ServiceFactory.getStatisticsService();
    private static final String AUTHORIZATION_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        Optional<UserDTO> optional=SessionUtils.giveUser(req.getSession());
        UserDTO userDTO;

        if (optional.isPresent()){
            userDTO=optional.get();
        } else {
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        LoginDTO loginDTO=new LoginDTO(userDTO.getLogin(),userDTO.getPassword());

        StatisticsDTO statisticsDTO=statisticsService.get();
        req.setAttribute("statistics",statisticsDTO);

        req.getRequestDispatcher("/ui/admin/stat.jsp").forward(req,resp);
    }
}
