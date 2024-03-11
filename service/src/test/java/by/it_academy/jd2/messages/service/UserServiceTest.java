package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testOnSavingAndChecking1(){
        IUserService userService= ServiceFactory.getUserService();

        userService.save("cvetochek","otodnogodovosmi","Иванова Светлана Андреевна", "11-03-1999");
        boolean check=userService.checkUser("cvetochek","otodnogodovosmi");
        Assertions.assertTrue(check);
    }

    @Test
    public void testOnSavingAndChecking2(){
        IUserService userService= ServiceFactory.getUserService();

        userService.save("cvetochek","otodnogodovosmi","Иванова Светлана Андреевна", "11-03-1999");
        boolean check=userService.checkUser("cvetoche","otodnogodovosmi");
        Assertions.assertFalse(check);
    }

    @Test
    public void testOnSavingAndChecking3(){
        IUserService userService= ServiceFactory.getUserService();

        userService.save("cvetochek","otodnogodovosmi","Иванова Светлана Андреевна", "11-03-1999");
        boolean check=userService.save("cvetochek","otodnogodovosmi","Иванова Светлана Семеновна", "11-03-1999");
        Assertions.assertFalse(check);
    }
}
