package by.it_academy.jd2.messages.dao;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.dao.api.IMessageDao;
import by.it_academy.jd2.messages.dao.api.IStatisticsDao;
import by.it_academy.jd2.messages.dao.api.IUserDao;
import by.it_academy.jd2.messages.dao.factory.DaoFactory;

public class StatisticsDao implements IStatisticsDao {
    private Long messages;
    private Long users;
    private Long activeUsers;
    private final IUserDao userDao= DaoFactory.getUserDao();
    private final IMessageDao messageDao=DaoFactory.getMessageDao();

    public StatisticsDao(Long messages, Long users, Long activeUsers) {
        this.messages = messages;
        this.users = users;
        this.activeUsers=activeUsers;
    }

    public StatisticsDao() {
        this.messages = 0L;
        this.users = 0L;
        this.activeUsers=0L;
    }


    @Override
    public StatisticsDTO get() {
        return StatisticsDTO.builder().users(this.users).messages(this.messages).activeUsers(this.activeUsers).build();
    }

    public void addMessage(){
        this.messages++;
    }

    public void addUser(){
        this.users++;
    }
    public void addActiveUser(){
        this.activeUsers++;
    }

    public void removeMessage(){
        this.messages--;
    }

    public void removeUser(){
        this.users--;
    }
    public void removeActiveUser(){
        this.activeUsers--;
    }
}
