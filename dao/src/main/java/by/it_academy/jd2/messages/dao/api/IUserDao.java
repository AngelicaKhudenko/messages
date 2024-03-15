package by.it_academy.jd2.messages.dao.api;

import by.it_academy.jd2.messages.core.dto.UserDTO;

import java.util.Optional;

public interface IUserDao {

    /**
     * Метод, сохраняющий пользователя в базу данных
     * @param userDTO - пользователь
     */
    void create (UserDTO userDTO);

    /**
     * Метод, возвращающий пользователя по логину
     * @param login - логин
     * @return - пользователь
     */
    Optional <UserDTO> getByLogin(String login);
}
