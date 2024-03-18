package by.it_academy.jd2.messages.service.api;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.dto.SendMessageDTO;

import java.util.List;

public interface IMessageService {
    /**
     * Метод, возвращающий список сообщений пользователя по его логину
     * @param login - логин пользователя
     * @return - список сообщений для данног пользователя
     */
    List<MessageDTO> getByUser(String login);

    /**
     * Метод, отправляющий сообщение
     * @param sendMessageDTO - сообщение для отправки
     */
    void send(UserDTO userDTO, SendMessageDTO sendMessageDTO);
}
