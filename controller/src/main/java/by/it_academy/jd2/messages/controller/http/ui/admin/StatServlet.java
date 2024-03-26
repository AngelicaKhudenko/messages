package by.it_academy.jd2.messages.controller.http.ui.admin;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatServlet extends HttpServlet {
    private final IStatisticsService statisticsService= ServiceFactory.getStatisticsService();
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        StatisticsDTO statisticsDTO=statisticsService.get();
        req.setAttribute("statistics",statisticsDTO);

        req.getRequestDispatcher("/ui/admin/stat.jsp").forward(req,resp);
    }
}
