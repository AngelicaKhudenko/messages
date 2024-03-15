package by.it_academy.jd2.messages.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTOBuilder {
    private String login;
    private String password;
    private String [] names;
    private LocalDate birthday;
    private LocalDateTime registration;
    private UserRole role;

    private UserDTOBuilder() {
    }

    /**
     * Возвращает созданный объект класса UserDTOBuilder
     * @return объект класса UserDTOBuilder
     */
    public static UserDTOBuilder builder(){
        return new UserDTOBuilder();
    }

    /**
     * Возвращает созданный объект класса UserDTO
     * @return объект класса UserDTO
     */
    public UserDTO build(){
        return new UserDTO(login,password,names,birthday,registration,role);
    }

    /**
     * Записывает информацию о логине пользователя и возвращает объект класса UserDTOBuilder
     * @param login - логин пользователя
     * @return объект класса UserDTOBuilder
     */
    public UserDTOBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    /**
     * Записывает информацию о пароле пользователя и возвращает объект класса UserDTOBuilder
     * @param password - пароль пользователя
     * @return объект класса UserDTOBuilder
     */
    public UserDTOBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Записывает информацию об имени пользователя и возвращает объект класса UserDTOBuilder
     * @param names - имя пользователя в виде массива
     * @return объект класса UserDTOBuilder
     */
    public UserDTOBuilder setNames(String[] names) {
        this.names = names;
        return this;
    }

    /**
     * Записывает информацию о дате рождения пользователя и возвращает объект класса UserDTOBuilder
     * @param birthday - информация о дате рождения пользоваетеля
     * @return объект класса UserDTOBuilder
     */
    public UserDTOBuilder setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * Записывает информацию о дате регистрации пользователя и возвращает объект класса UserDTOBuilder
     * @param registration - информация о дате регистрации пользоваетеля
     * @return объект класса UserDTOBuilder
     */
    public UserDTOBuilder setRegistration(LocalDateTime registration) {
        this.registration = registration;
        return this;
    }

    /**
     * Записывает информацию о роли пользователя и возвращает объект класса UserDTOBuilder
     * @param role - роль пользователя
     * @return объект класса UserDTOBuilder
     */
    public UserDTOBuilder setRole(UserRole role) {
        this.role = role;
        return this;
    }
}
