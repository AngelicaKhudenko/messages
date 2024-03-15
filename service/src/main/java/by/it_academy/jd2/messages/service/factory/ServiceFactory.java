package by.it_academy.jd2.messages.service.factory;

import by.it_academy.jd2.messages.dao.factory.DaoFactory;
import by.it_academy.jd2.messages.service.LoginService;
import by.it_academy.jd2.messages.service.MessageService;
import by.it_academy.jd2.messages.service.UserService;
import by.it_academy.jd2.messages.service.api.ILoginService;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.api.IUserService;

public class ServiceFactory {
    private volatile static ILoginService loginService;
    private volatile static IUserService userService;
    private volatile static IMessageService messageService;

    /**
     * Метод, возвращающий объект LoginService (уже созданный или создает новый в случае его отсутствия)
     * @return - объект LoginService
     */
    public static ILoginService getLoginService(){
        if (loginService==null){
            synchronized (ServiceFactory.class){
                if(loginService==null){
                    loginService=new LoginService(getUserService());
                }
            }
        }
        return loginService;
    }

    /**
     * Метод, возвращающий объект MessageService (уже созданный или создает новый в случае его отсутствия)
     * @return - объект MessageService
     */
    public static IMessageService getMessageService(){
        if (messageService==null){
            synchronized (ServiceFactory.class){
                if (messageService==null){
                    messageService=new MessageService(DaoFactory.getMessageDao(),getUserService());
                }
            }
        }

        return messageService;
    }

    /**
     * Метод, возвращающий объект UserService (уже созданный или создает новый в случае его отсутствия)
     * @return - объект UserService
     */
    public static IUserService getUserService(){
        if (userService==null){
            synchronized (ServiceFactory.class){
                if (userService==null){
                    userService=new UserService(DaoFactory.getUserDao());
                }
            }
        }
        return userService;
    }
}
