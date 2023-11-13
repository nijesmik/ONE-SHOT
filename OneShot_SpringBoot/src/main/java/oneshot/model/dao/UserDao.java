package oneshot.model.dao;

import oneshot.model.dto.User;

public interface UserDao {
    User selectOne(String id);

    int insertUser(User user);

}