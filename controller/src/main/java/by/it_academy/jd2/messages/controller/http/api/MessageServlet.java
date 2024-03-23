package by.it_academy.jd2.messages.controller.http.api;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.dto.SendMessageDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final IMessageService messageService= ServiceFactory.getMessageService();
    private final IStatisticsService statisticsService=ServiceFactory.getStatisticsService();
    private final static String LOGIN_PARAM_NAME="login";
    private final static String TEXT_PARAM_NAME="text";
    private static final String AUTHORIZATION_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer=resp.getWriter();

        if (session.isNew()) {
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        UserDTO userDTO=SessionUtils.giveUser(session);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer=resp.getWriter();

        if (session.isNew()) {
            throw new UnauthorizedException(AUTHORIZATION_MISTAKE_MESSAGE);
        }

        UserDTO sender=SessionUtils.giveUser(session);

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

        statisticsService.addMessage();
        resp.setStatus(201);
        writer.write("<p>Сообщение доставлено успешно"+"</p>");
    }
}
