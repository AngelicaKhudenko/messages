package by.it_academy.jd2.messages.service.api;

import by.it_academy.jd2.messages.core.dto.UserDTO;
import by.it_academy.jd2.messages.service.dto.LoginDTO;

public interface ILoginService {

    /**
     * Метод, возвращающий пользователя, соответствующего переданному паролю и логину в объекте LoginDTO
     * @param loginDTO - логин и пароль пользователя в объекте LoginDTO
     * @return - пользователь, соответствующий переданным логину и паролю
     */
    UserDTO login(LoginDTO loginDTO);
}
