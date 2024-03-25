package by.it_academy.jd2.messages.dao.api;

import by.it_academy.jd2.messages.core.dto.MessageDTO;

import java.util.List;

public interface IMessageDao {

    /**
     * Возвращает список сообщений пользователя с заданным логином
     * @param login - логин пользователя, сообщения которого запрашиваются
     * @return - список сообщений пользователя с заданным логином
     */
    List<MessageDTO> get(String login);

    /**
     * Создает сообщение в базе сообщений
     * @param messageDTO  - сообщение для записи
     */
    void create (MessageDTO messageDTO);
}
