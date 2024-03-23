package by.it_academy.jd2.messages.service.api;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import by.it_academy.jd2.messages.service.dto.LoginDTO;

public interface IStatisticsService {
    /**
     * Метод, возвращающий статистику приложения в виде объекта класса StatisticsDTO
     * @param loginDTO - логин и пароль пользователя, заправшивающий статистику
     * @return - статистика приложения в виде объекта класса StatisticsDTO
     */
    StatisticsDTO get(LoginDTO loginDTO) throws UnauthorizedException;
    /**
     * Метод, увеличивающий количество сообщений в статистике приложения на один
     */
    void addMessage();

    /**
     * Метод, увеличивающий количество пользователей в статистике приложения на один
     */
    void addUser();

    /**
     * Метод, уменьшающий количество сообщений в статистике приложения на один
     */
    void removeMessage();

    /**
     * Метод, уменьшающий количество пользователей в статистике приложения на один
     */
    void removeUser();
    /**
     * Метод, уменьшающий количество активных пользователей в статистике приложения на один
     */
    void removeActiveUser();

    /**
     * Метод, увеличивающий количество активных пользователей в статистике приложения на один
     */
    void addActiveUser();
}
