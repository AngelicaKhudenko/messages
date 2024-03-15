package by.it_academy.jd2.messages.dao;

import by.it_academy.jd2.messages.core.dto.MessageDTO;
import by.it_academy.jd2.messages.dao.api.IMessageDao;

import java.util.*;

public class MessageDao implements IMessageDao {
    private final Map<String, List<MessageDTO>> messages=new HashMap<>();

    @Override
    public List<MessageDTO> get(String login) {
        return messages.get(login);
    }

    @Override
    public void create(MessageDTO messageDTO) {
        if (messages.containsKey(messageDTO.getAddressee())){
            List<MessageDTO> savedMessages=messages.get(messageDTO.getAddressee());
            savedMessages.add(messageDTO);
            messages.put(messageDTO.getAddressee(),savedMessages);
        } else {
            List<MessageDTO> createdMessages=new ArrayList<>();
            createdMessages.add(messageDTO);
            messages.put(messageDTO.getAddressee(),createdMessages);
        }
    }
}
