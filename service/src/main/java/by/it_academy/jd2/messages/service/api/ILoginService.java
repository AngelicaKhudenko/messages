package by.it_academy.jd2.messages.service.api;

public interface ILoginService {
    /**
     * Метод, проверяющий, есть ли переданный пользователь в системе,
     * а также в случае наличия такого логина, проверяет правильность пароля
     * @param login - логин
     * @param password - пароль
     * @return true - пользователь в системе есть, пароль верный
     *         false - пользователя в системе нет или пароль неверный
     * @throws IllegalArgumentException
     */
    boolean checkUser(String login, String password) throws IllegalArgumentException;
}
