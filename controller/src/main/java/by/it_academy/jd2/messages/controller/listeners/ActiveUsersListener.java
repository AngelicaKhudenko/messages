package by.it_academy.jd2.messages.controller.listeners;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ActiveUsersListener implements HttpSessionListener {
    private final IStatisticsService statisticsService=ServiceFactory.getStatisticsService();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        if (SessionUtils.giveUser(session)!=null){
            statisticsService.addActiveUser();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        if (SessionUtils.giveUser(session)!=null) {
            statisticsService.removeActiveUser();
        }
    }
}
