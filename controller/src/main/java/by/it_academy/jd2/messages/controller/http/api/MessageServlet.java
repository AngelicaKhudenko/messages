package by.it_academy.jd2.messages.controller.http.api;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.dto.SendMessageDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final IMessageService messageService= ServiceFactory.getMessageService();
    private final static String LOGIN_PARAM_NAME="login";
    private final static String TEXT_PARAM_NAME="text";
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

        PrintWriter writer=resp.getWriter();

        List<MessageDTO> messages=messageService.getByUser(userDTO.getLogin());

        if (messages==null){
            writer.write("<p>Сообщений нет"+"</p>");
            return;
        }

        for (MessageDTO messageDTO:messages){
            writer.write("<p>Время отправки сообщения: "+messageDTO.getPost()+"</p>");
            writer.write("<p>Отправитель сообщения: "+messageDTO.getSender()+"</p>");
            writer.write("<p>Текст сообщения: "+messageDTO.getText()+"</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        Optional<UserDTO> optional=SessionUtils.giveUser(req.getSession());
        UserDTO sender;

        if (optional.isPresent()){
            sender=optional.get();
        } else {
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        PrintWriter writer=resp.getWriter();

        String login=req.getParameter(LOGIN_PARAM_NAME);
        String text=req.getParameter(TEXT_PARAM_NAME);

        if (login==null||login.isBlank()){
            throw new IllegalArgumentException("Введите логин пользователя");
        }

        SendMessageDTO sendMessageDTO=SendMessageDTO.builder()
                .addressee(login)
                .text(text)
                .build();

        messageService.send(sender,sendMessageDTO);

        resp.setStatus(201);
        writer.write("<p>Сообщение доставлено успешно</p>");
    }
}
