package by.it_academy.jd2.messages.dao;

import by.it_academy.jd2.messages.dao.api.IUserDao;
import by.it_academy.jd2.messages.dao.dto.AdminDTO;
import by.it_academy.jd2.messages.dao.dto.UserDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class UserDao implements IUserDao {
    private final Set<UserDTO> users=new HashSet<>();
    private final Set<AdminDTO> admins=new HashSet<>();

    public UserDao(String login, String password, String name, String dateOfBirthInLine) {
        // Добавление админстратора
        String [] names=name.trim().split(" +");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthInLine, formatter);
        AdminDTO admin=new AdminDTO(login,password,names,dateOfBirth);
        admins.add(admin);
    }

    @Override
    public boolean save(String login, String password, String[] names, LocalDate dateOfBirth) {
        for (UserDTO user : users) {
            String loginInBase = user.getLogin();
            if (loginInBase.equals(login)) {
                return false;
            }
        }

        UserDTO user=new UserDTO(login,password,names,dateOfBirth);
        users.add(user);
        return true;
    }

    @Override
    public boolean checkUser(String login, String password) {
        for (UserDTO user : users) {
            String loginInBase = user.getLogin();
            if (loginInBase.equals(login)) {
                String passwordInBase = user.getPassword();
                if (passwordInBase.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
