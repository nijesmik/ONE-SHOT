package oneshot.model.service;

import javax.servlet.http.HttpSession;

import oneshot.model.dto.User;

public interface UserService {
    User login(User user, HttpSession session);

    int signup(User user);

    int idCheck(String email);

    int updateUser(User user, int userId);

    int deleteUser(int userId);
}