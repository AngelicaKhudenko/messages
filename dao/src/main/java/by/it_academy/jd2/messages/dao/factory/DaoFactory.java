package by.it_academy.jd2.messages.dao.factory;

import by.it_academy.jd2.messages.dao.UserDao;
import by.it_academy.jd2.messages.dao.api.IUserDao;

public class DaoFactory {
    private volatile static IUserDao userDao;

    /**
     * Метод, возвращающий объект UserDao (уже созданный или создает новый в случае его отсутствия)
     * @return - объект UserDao
     */
    public static IUserDao getUserDao(){
        if (userDao==null){
            synchronized (DaoFactory.class){
                if (userDao==null){
                    userDao=new UserDao("mainAdmin","admin123_jkl","Худенко Анжелика Сергеевна", "14-10-2000");
                }
            }
        }
        return userDao;
    }
}
