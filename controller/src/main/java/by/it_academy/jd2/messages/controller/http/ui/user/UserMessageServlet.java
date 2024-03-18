package by.it_academy.jd2.messages.controller.http.ui.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebServlet(urlPatterns = "/ui/user/message")
public class UserMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/user/message.jsp").forward(req,resp);
    }
}
