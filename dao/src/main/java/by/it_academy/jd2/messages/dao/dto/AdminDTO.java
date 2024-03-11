package by.it_academy.jd2.messages.dao.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AdminDTO {
    String login;
    String password;
    String [] names;
    LocalDate dateOfBirth;
    LocalDateTime dateOfRegistration;
    Roles role;

    public AdminDTO(String login, String password, String[] names, LocalDate dateOfBirth) {
        this.login = login;
        this.password = password;
        this.names = names;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = LocalDateTime.now();
        this.role = Roles.ADMIN;
    }

    /**
     * Метод, возвращающий массив, содержащий ФИО администратора
     * @return - массив, содержащий ФИО администратора
     */
    public String[] getNames() {
        return names;
    }

    /**
     * Метод, возвращающий дату регистрации администратора
     * @return - дата регистрации администратора
     */
    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }
}
