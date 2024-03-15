package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.dao.api.IMessageDao;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.api.IUserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessageService implements IMessageService {
    private final IMessageDao messageDao;
    private final IUserService userService;

    public MessageService(IMessageDao messageDao,IUserService userService) {
        this.messageDao = messageDao;
        this.userService=userService;
    }

    @Override
    public List<MessageDTO> getByUser(String login) {
        return messageDao.get(login);
    }

    @Override
    public void send(MessageDTO messageDTO) {
        if (messageDTO==null){
            throw new IllegalArgumentException("Сообщение не должно быть пустым");
        }

        Optional<UserDTO> user=userService.getByLogin(messageDTO.getAddressee());
        if (user.isEmpty()){
            throw new IllegalArgumentException("Пользователя с таким логином не существует");
        }

        messageDTO.setPost(LocalDateTime.now());
        messageDao.create(messageDTO);
    }
}
