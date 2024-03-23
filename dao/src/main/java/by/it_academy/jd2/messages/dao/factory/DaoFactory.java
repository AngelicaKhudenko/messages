package by.it_academy.jd2.messages.dao.factory;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.core.dto.UserRole;
import by.it_academy.jd2.messages.dao.MessageDao;
import by.it_academy.jd2.messages.dao.StatisticsDao;
import by.it_academy.jd2.messages.dao.UserDao;
import by.it_academy.jd2.messages.dao.api.IMessageDao;
import by.it_academy.jd2.messages.dao.api.IStatisticsDao;
import by.it_academy.jd2.messages.dao.api.IUserDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DaoFactory {
    private volatile static IUserDao userDao;
    private volatile static IMessageDao messageDao;
    private volatile static IStatisticsDao statisticsDao;

    private static final String [] nameOfAdmin=new String[]{"Главный", "Администратор"};
    private static final LocalDate birthdayOfAdmin= LocalDate.parse("14-10-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    /**
     * Метод, возвращающий объект UserDao (уже созданный или создает новый в случае его отсутствия).
     * В случае создания объекта создает администратора
     * @return - объект UserDao
     */
    public static IUserDao getUserDao(){
        if (userDao==null){
            synchronized (DaoFactory.class){
                if (userDao==null){
                    userDao=new UserDao();

                    userDao.create(new UserDTO("admin123","otodnogodovosmi",nameOfAdmin,
                            birthdayOfAdmin, LocalDateTime.now(), UserRole.ADMIN));
                }
            }
        }
        return userDao;
    }

    /**
     * Метод, возвращающий объект MessageDao (уже созданный или создает новый в случае его отсутствия)
     * @return - объект MessageDao
     */
    public static IMessageDao getMessageDao(){
        if(messageDao==null){
            synchronized (DaoFactory.class){
                if(messageDao==null){
                    messageDao=new MessageDao();
                }
            }
        }

        return messageDao;
    }

    /**
     * Метод, возвращающий объект StatisticsDao (уже созданный или создает новый в случае его отсутствия)
     * @return - объект StatisticsDao
     */
    public static IStatisticsDao getStatisticsDao(){
        if(statisticsDao==null){
            synchronized (DaoFactory.class){
                if(statisticsDao==null){
                    statisticsDao=new StatisticsDao();
                }
            }
        }

        return statisticsDao;
    }
}
