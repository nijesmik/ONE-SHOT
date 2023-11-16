package oneshot.model.dao;

import oneshot.model.dto.User;

public interface UserDao {
    User login(String id);

    int signup(User user);

}