package by.it_academy.jd2.messages.dao;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.dao.api.IStatisticsDao;

public class StatisticsDao implements IStatisticsDao {
    private volatile Long  messages;
    private volatile Long users;
    private volatile Long activeUsers;

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

    public synchronized void addMessage(){
        this.messages++;
    }

    public synchronized void addUser(){
        this.users++;
    }
    public synchronized void addActiveUser(){
        this.activeUsers++;
    }

    public synchronized void removeMessage(){
        this.messages--;
    }

    public synchronized void removeUser(){
        this.users--;
    }
    public synchronized void removeActiveUser(){
        this.activeUsers--;
    }
}
