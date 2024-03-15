package by.it_academy.jd2.messages.service.dto;

public class LoginDTO {
    private String login;
    private String password;

    public LoginDTO() {

    }

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Возвращает логин
     * @return логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Устанавливает логин
     * @param login - логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Возвращает пароль
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Устанавливает пароль
     * @param password - пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
