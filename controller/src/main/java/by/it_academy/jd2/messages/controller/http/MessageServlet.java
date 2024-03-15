package by.it_academy.jd2.messages.controller.http;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.api.IMessageService;
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
    private final static String LOGIN_PARAM_NAME="login";
    private final static String TEXT_PARAM_NAME="text";
    private static final String AUTHORIZATION_MISTAKE_MESSAGE="Не выполнен вход в программу. Необходимо авторизоваться";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer=resp.getWriter();

        if (session.isNew()){
            writer.write(AUTHORIZATION_MISTAKE_MESSAGE);
            resp.setStatus(401);
            return;
        }

        UserDTO userDTO=(UserDTO) session.getAttribute("user");
        List<MessageDTO> messages=messageService.getByUser(userDTO.getLogin());

        if (messages==null){
            writer.write("<p>"+"Сообщений нет"+"</p>");
            return;
        }

        for (int i=0; i<messages.size(); i++){
            writer.write("<p>"+messages.get(i).toString()+"</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer=resp.getWriter();

        if (session.isNew()){
            writer.write(AUTHORIZATION_MISTAKE_MESSAGE);
            resp.setStatus(401);
            return;
        }

        UserDTO sender=(UserDTO) session.getAttribute("user");

        String login=req.getParameter(LOGIN_PARAM_NAME);
        String text=req.getParameter(TEXT_PARAM_NAME);

        if (login==null){
            writer.write("<p>"+"Введите логин пользователя"+"<p>");
            resp.setStatus(400);
            return;
        }

        MessageDTO messageDTO=new MessageDTO(sender.getLogin(),login,text);

        try{
            messageService.send(messageDTO);
        } catch (IllegalArgumentException e){
            writer.write("<p>"+"Ошибка при отправке сообщения: "+e.getMessage()+"</p>");
        }

        writer.write("<p>"+"Сообщение доставлено успешно"+"</p>");
    }
}
