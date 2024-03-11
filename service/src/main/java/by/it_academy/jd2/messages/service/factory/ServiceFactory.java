package by.it_academy.jd2.messages.service.factory;

import by.it_academy.jd2.messages.dao.factory.DaoFactory;
import by.it_academy.jd2.messages.service.LoginService;
import by.it_academy.jd2.messages.service.UserService;
import by.it_academy.jd2.messages.service.api.ILoginService;
import by.it_academy.jd2.messages.service.api.IUserService;

public class ServiceFactory {
    private volatile static ILoginService loginService;
    private volatile static IUserService userService;

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
