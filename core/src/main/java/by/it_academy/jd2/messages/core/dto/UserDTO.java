package by.it_academy.jd2.messages.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {
    private String login;
    private String password;
    private String [] names;
    private LocalDate birthday;
    private LocalDateTime registration;
    private UserRole role;

    public UserDTO() {

    }

    public UserDTO(String login, String password, String[] names, LocalDate birthday, LocalDateTime registration, UserRole role) {
        this.login = login;
        this.password = password;
        this.names = names;
        this.birthday = birthday;
        this.registration = registration;
        this.role = role;
    }

    /**
     * Метод, возвращающий логин пользователя
     * @return - логин пользователя
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод, устанавливающий значения логина пользователя
     * @param login - логин пользователя
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Метод, возвращающий пароль пользователя
     * @return - пароль пользователя
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод, устанавливающий пароль пользователя
     * @param password - пароль пользователя
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Метод, возвращающий массив, содержащий имя пользователя
     * @return - массив, содержащий имя пользователя
     */
    public String[] getNames() {
        return names;
    }

    /**
     * Метод, устанавливающий имя пользователя
     * @param names - массив имен пользователя, например, ФИО
     */
    public void setNames(String[] names) {
        this.names = names;
    }

    /**
     * Метод, возвращающий дату рождения пользователя
     * @return - дата рождения пользователя
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Метод, устанавлаивающий дату рождения пользователя
     * @param birthday - дата рождения пользвателя
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Метод, возвращающий дату регистрации пользователя
     * @return - дата регистрации пользователя
     */
    public LocalDateTime getRegistration() {
        return registration;
    }

    /**
     * Метод, устанавливающий дату регистрации пользователя
     * @param registration - дата регистрации пользователя
     */
    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    /**
     * Метод, возвращающий роль пользователя
     * @return USER - пользователь
     *         ADMIN - администратор
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Метод, устанавливающий роль пользоваетеля
     * @param role - роль пользователя (например, USER - пользователь, ADMIN - администратор)
     */
    public void setRole(UserRole role) {
        this.role = role;
    }
}
