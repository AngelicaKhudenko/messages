package by.it_academy.jd2.messages.service.dto;

import java.time.LocalDate;

public class RegistrationUserDTO {
    private String login;
    private String password;
    private String [] names;
    private LocalDate birthday;

    public RegistrationUserDTO() {

    }

    public RegistrationUserDTO(String login, String password, String[] names, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.names = names;
        this.birthday = birthday;
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
}
