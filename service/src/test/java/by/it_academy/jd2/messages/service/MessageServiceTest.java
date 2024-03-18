package by.it_academy.jd2.messages.service;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.api.IMessageService;
import by.it_academy.jd2.messages.service.api.IUserService;
import by.it_academy.jd2.messages.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.messages.service.dto.SendMessageDTO;
import by.it_academy.jd2.messages.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class MessageServiceTest {
    @Test
    @DisplayName("Тестирование на получение пустого списка сообщений")
    public void testOnGettingEmptyMessage(){
        IUserService userService=ServiceFactory.getUserService();
        IMessageService messageService=ServiceFactory.getMessageService();

        String login="cvetocheck";
        String password="otodnogodovosmi";
        String []names="Иванова Светлана Андреевна".trim().split(" +");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday=LocalDate.parse("11-03-1999",formatter);

        RegistrationUserDTO registrationUserDTO=new RegistrationUserDTO(login,password, names,birthday);
        userService.create(registrationUserDTO);

        List<MessageDTO> messages=messageService.getByUser(login);
        Assertions.assertNull(messages);
    }

    @Test
    @DisplayName("Тестирование на отправку и получение сообщения")
    public void testOnSendingAndGettingExistingMessage(){
        IUserService userService=ServiceFactory.getUserService();
        IMessageService messageService=ServiceFactory.getMessageService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String loginSender="sveta";
        String passwordSender="otodnogodovosmi";
        String []namesSender="Иванова Светлана Андреевна".trim().split(" +");
        LocalDate birthdaySender=LocalDate.parse("11-03-1999",formatter);

        String loginAddressee="spring";
        String passwordAddressee="1234578";
        String []namesAddressee="Иванова Людмила Семеновна".trim().split(" +");
        LocalDate birthday=LocalDate.parse("10-11-1979",formatter);

        RegistrationUserDTO sender=new RegistrationUserDTO(loginSender,passwordSender, namesSender,birthdaySender);
        userService.create(sender);

        RegistrationUserDTO addressee=new RegistrationUserDTO(loginAddressee,passwordAddressee, namesAddressee,birthday);
        userService.create(addressee);

        SendMessageDTO sendMessageDTO=SendMessageDTO.builder()
                .text("Привет")
                .addressee(loginAddressee)
                .build();

        Optional<UserDTO> userDTO=userService.getByLogin(loginSender);

        UserDTO user=null;
        if (userDTO.isPresent()){
            user=userDTO.get();
        }

        messageService.send(user,sendMessageDTO);

        List<MessageDTO> messages=messageService.getByUser(loginAddressee);
        Assertions.assertEquals(messages.get(0).getText(),sendMessageDTO.getText());
        Assertions.assertEquals(messages.get(0).getSender(),loginSender);
    }
}
