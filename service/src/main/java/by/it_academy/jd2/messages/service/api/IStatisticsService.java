package by.it_academy.jd2.messages.service.api;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;

public interface IStatisticsService {

    /**
     * Метод, возвращающий статистику приложения в виде объекта класса StatisticsDTO
     * @return - статистика приложения в виде объекта класса StatisticsDTO
     */
    StatisticsDTO get();

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
