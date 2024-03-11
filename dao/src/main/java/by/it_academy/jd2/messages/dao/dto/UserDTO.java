package by.it_academy.jd2.messages.dao.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {
    String login;
    String password;
    String [] names;
    LocalDate dateOfBirth;
    LocalDateTime dateOfRegistration;
    Roles role;

    public UserDTO(String login, String password, String[] names, LocalDate dateOfBirth) {
        this.login = login;
        this.password = password;
        this.names = names;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = LocalDateTime.now();
        this.role = Roles.USER;
    }

    /**
     * Метод, возвращающий логин пользователя
     * @return - логин пользователя
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод, возвращающий пароль пользователя
     * @return - пароль пользователя
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод, возвращающий массив, содержащий имя пользователя
     * @return - массив, содержащий имя пользователя
     */
    public String[] getNames() {
        return names;
    }

    /**
     * Метод, возвращающий дату рождения пользователя
     * @return - дата рождения пользователя
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Метод, возвращающий дату регистрации пользователя
     * @return - дата регистрации пользователя
     */
    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }
}
