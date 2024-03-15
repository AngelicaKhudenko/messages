package by.it_academy.jd2.messages.service.api;

import by.it_academy.jd2.messages.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;

import java.util.Optional;

public interface IUserService {

    /**
     * Метод, создающий пользователя
     * @param userDTO - пользователь
     */
    void create(UserDTO userDTO);

    /**
     * Метод, регистрирующий пользователя в системе с ролью "Пользователь"
     * @param registrationUserDTO - пользователь с ролью "Пользователь"
     */
    void create(RegistrationUserDTO registrationUserDTO);

    /**
     * Метод, возвращающий пользователя по логину
     * @param login - логин
     * @return - пользователь
     */
    Optional<UserDTO> getByLogin(String login);
}
