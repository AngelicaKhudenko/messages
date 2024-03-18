package by.it_academy.jd2.messages.dao;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.dao.api.IMessageDao;

import java.util.*;

public class MessageDao implements IMessageDao {
    private final Map<String, List<MessageDTO>> forUser =new HashMap<>();
    private final Map<String, List<MessageDTO>> fromUser =new HashMap<>();

    @Override
    public List<MessageDTO> get(String login) {
        return forUser.get(login);
    }

    @Override
    public void create(MessageDTO messageDTO) {
        if (forUser.containsKey(messageDTO.getAddressee())){
            List<MessageDTO> savedMessages=forUser.get(messageDTO.getAddressee());
            savedMessages.add(messageDTO);
            forUser.put(messageDTO.getAddressee(),savedMessages);
        } else {
            List<MessageDTO> createdMessages=new ArrayList<>();
            createdMessages.add(messageDTO);
            forUser.put(messageDTO.getAddressee(),createdMessages);
        }

        if (fromUser.containsKey(messageDTO.getAddressee())){
            List<MessageDTO> savedMessages=fromUser.get(messageDTO.getAddressee());
            savedMessages.add(messageDTO);
            fromUser.put(messageDTO.getAddressee(),savedMessages);
        } else {
            List<MessageDTO> createdMessages=new ArrayList<>();
            createdMessages.add(messageDTO);
            fromUser.put(messageDTO.getAddressee(),createdMessages);
        }
    }
}
