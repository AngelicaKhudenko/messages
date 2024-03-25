package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.StatisticsDTO;
import by.it_academy.jd2.messages.dao.api.IStatisticsDao;
import by.it_academy.jd2.messages.service.api.IStatisticsService;


public class StatisticsService implements IStatisticsService {
    private final IStatisticsDao statisticsDao;

    public StatisticsService(IStatisticsDao statisticsDao){
        this.statisticsDao=statisticsDao;
    }
    @Override
    public StatisticsDTO get() {
        return statisticsDao.get();
    }

    @Override
    public void addMessage() {
        statisticsDao.addMessage();
    }

    @Override
    public void addUser() {
        statisticsDao.addUser();
    }

    @Override
    public void addActiveUser() {
        statisticsDao.addActiveUser();
    }

    @Override
    public void removeMessage() {
        statisticsDao.removeMessage();
    }

    @Override
    public void removeUser() {
        statisticsDao.removeUser();
    }

    @Override
    public void removeActiveUser() {
        statisticsDao.removeActiveUser();
    }
}
