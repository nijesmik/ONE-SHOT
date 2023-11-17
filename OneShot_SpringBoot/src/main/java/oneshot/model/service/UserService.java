package oneshot.model.service;

import oneshot.model.dto.User;

public interface UserService {
    User login(User user);

    int signup(User user);

    int updateUser(User user, int userId);

    int deleteUser(int userId);
}