package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.dao.api.IMessageDao;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.SendMessageDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessageService implements IMessageService {
    private final IMessageDao messageDao;
    private final IUserService userService;
    private final IStatisticsService statisticsService;

    public MessageService(IMessageDao messageDao,IUserService userService, IStatisticsService statisticsService) {
        this.messageDao = messageDao;
        this.userService=userService;
        this.statisticsService=statisticsService;
    }

    @Override
    public List<MessageDTO> getByUser(String login) {
        return messageDao.get(login);
    }

    @Override
    public void send(UserDTO userDTO, SendMessageDTO sendMessageDTO) {
        if (sendMessageDTO==null){
            throw new IllegalArgumentException("Сообщение не должно быть пустым");
        }

        MessageDTO messageDTO= MessageDTO.builder()
                .sender(userDTO.getLogin())
                .addressee(sendMessageDTO.getAddressee())
                .text(sendMessageDTO.getText())
                .post(LocalDateTime.now())
                .build();

        Optional<UserDTO> userSender=userService.getByLogin(userDTO.getLogin());
        Optional<UserDTO> userAddressee=userService.getByLogin(sendMessageDTO.getAddressee());


        if (userSender.isEmpty()){
            throw new IllegalArgumentException("Пользователя-отправителя сообщения с таким логином не существует");
        }

        if (userAddressee.isEmpty()){
            throw new IllegalArgumentException("Пользователя-получателя сообщения с таким логином не существует");
        }

        messageDao.create(messageDTO);
        statisticsService.addMessage();
    }
}
