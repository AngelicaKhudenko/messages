package by.it_academy.jd2.messages.controller.http.api;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.dto.UserRole;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatisticsService statisticsService=ServiceFactory.getStatisticsService();
    private static final String AUTHORIZATION_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";
    private static final String ACCESS_FORBIDDEN_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        Optional<UserDTO> optional=SessionUtils.giveUser(req.getSession());

        if (optional.isEmpty()){
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        UserDTO userDTO=optional.get();
        if (!UserRole.ADMIN.equals(userDTO.getRole())){
            resp.setStatus(403);
            throw new IllegalArgumentException(ACCESS_FORBIDDEN_MISTAKE_MESSAGE);
        }

        StatisticsDTO statisticsDTO=statisticsService.get();

        PrintWriter writer=resp.getWriter();

        if (statisticsDTO==null){
            writer.write("<p>Статистика пуста</p>");
            return;
        }

        writer.write("<p>Статистика приложения</p>");
        writer.write("<p>Количество активных пользователей сообщений: "+statisticsDTO.getActiveUsers()+"</p>");
        writer.write("<p>Общее количество пользователей в приложении: "+statisticsDTO.getUsers()+"</p>");
        writer.write("<p>Количество отправленных сообщений: "+statisticsDTO.getMessages()+"</p>");
    }
}
