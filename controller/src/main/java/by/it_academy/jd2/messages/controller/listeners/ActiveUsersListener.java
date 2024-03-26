package by.it_academy.jd2.messages.controller.listeners;


import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.service.api.IStatisticsService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class ActiveUsersListener implements HttpSessionAttributeListener {
    private final IStatisticsService statisticsService=ServiceFactory.getStatisticsService();

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

        if (SessionUtils.giveUser(se.getSession()).isPresent()){
            statisticsService.addActiveUser();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

        if (SessionUtils.giveUser(se.getSession()).isPresent()){
            statisticsService.removeActiveUser();
        }
    }
}
