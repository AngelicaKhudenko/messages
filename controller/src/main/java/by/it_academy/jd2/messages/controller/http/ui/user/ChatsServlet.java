package by.it_academy.jd2.messages.controller.http.ui.user;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {
    private final IMessageService messageService= ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        List< MessageDTO> messages=messageService.getByUser(SessionUtils.giveUser(req.getSession()).getLogin());

        req.setAttribute("messages",messages);

        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req,resp);
    }
}
