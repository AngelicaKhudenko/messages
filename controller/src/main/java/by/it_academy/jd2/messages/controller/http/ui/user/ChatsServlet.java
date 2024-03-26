package by.it_academy.jd2.messages.controller.http.ui.user;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {
    private final IMessageService messageService= ServiceFactory.getMessageService();
    private static final String AUTHORIZATION_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        Optional<UserDTO> optional=SessionUtils.giveUser(req.getSession());

        if (optional.isEmpty()){
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        List<MessageDTO> messages=messageService.getByUser(optional.get().getLogin());

        req.setAttribute("messages",messages);

        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req,resp);
    }
}
