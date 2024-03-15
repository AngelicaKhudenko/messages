package by.it_academy.jd2.messages.dao;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.dao.api.IUserDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDao implements IUserDao {
    private final Map<String, UserDTO> users=new HashMap<>();

    @Override
    public void create(UserDTO userDTO) {
        if (this.users.containsKey(userDTO.getLogin())){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }

        this.users.put(userDTO.getLogin(),userDTO);
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return Optional.ofNullable(this.users.get(login));
    }
}
