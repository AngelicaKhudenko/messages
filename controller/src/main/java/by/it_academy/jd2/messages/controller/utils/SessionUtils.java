package by.it_academy.jd2.messages.controller.utils;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class SessionUtils {
    private final static String USER_ATTRIBUTE = "user";

    /**
     * Метод, сохранающий в сессию пользователя
     * @param httpSession - переданная сессия
     * @param userDTO - пользователь для сохранения
     */
    public static void saveUser(HttpSession httpSession, UserDTO userDTO){
        if (httpSession==null){
            throw new IllegalStateException("Сессия отсутствует");
        }

        httpSession.setAttribute(USER_ATTRIBUTE,userDTO);
    }

    /**
     * Метод, возвращающий пользователя из переданной сессии
     * @param httpSession - сессия
     * @return - пользователь UserDTO
     */
    public static Optional<UserDTO> giveUser(HttpSession httpSession){
        if (httpSession==null){
            throw new IllegalStateException("Сессия отсутствует");
        }

        Object attribute=httpSession.getAttribute(USER_ATTRIBUTE);

        return Optional.ofNullable((UserDTO) attribute);
    }
}
