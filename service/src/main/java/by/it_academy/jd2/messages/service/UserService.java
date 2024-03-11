package by.it_academy.jd2.messages.service;
import by.it_academy.jd2.messages.dao.api.IUserDao;
import by.it_academy.jd2.messages.service.api.IUserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserService implements IUserService {
    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean save(String login, String password, String names, String birthInString) {
        String []namesInArray=names.trim().split(" +");
        if (namesInArray.length!=3){
            throw new IllegalArgumentException("Необходимо ввести ФИО для регистрации");
        }

        if (login==null||password==null){
            throw new IllegalArgumentException("Переданы некорректные значения. Заполните все поля");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthInString, formatter);
        return userDao.save(login, password, namesInArray, dateOfBirth);
    }

    @Override
    public boolean checkUser(String login, String password) {
        return userDao.checkUser(login,password);
    }
}
