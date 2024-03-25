package by.it_academy.jd2.messages.controller.http.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (urlPatterns = "/ui/signIn")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/ui/signIn.jsp").forward(req,resp);
    }
}
