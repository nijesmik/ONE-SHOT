package oneshot.model.service;

import oneshot.model.dto.User;

public interface UserService {
    User login(User user);

    int signup(User user);

}