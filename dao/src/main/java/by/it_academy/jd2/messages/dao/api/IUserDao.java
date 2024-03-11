package by.it_academy.jd2.messages.dao.api;

import java.time.LocalDate;

public interface IUserDao {
    /**
     * Метод, сохраняющий пользователя в базу данных
     * @param login - логин
     * @param password - пароль
     * @param names - массив имен: ФИО
     * @param dateOfBirth - дата рождения
     * @return true-пользователь сохранен
     *         false-пользователь с таким логином уже есть
     */
    boolean save(String login, String password, String [] names, LocalDate dateOfBirth);

    /**
     * Метод, проверяющий, есть ли переданный пользователь в системе,
     * а также в случае наличия такого логина, проверяет правильность пароля
     * @param login - логин
     * @param password - пароль
     * @return true - пользователь в системе есть, пароль верный
     *         false - пользователя в системе нет или пароль неверный
     */
    boolean checkUser(String login, String password);
}
