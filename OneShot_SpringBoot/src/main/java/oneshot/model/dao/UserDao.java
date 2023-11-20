package oneshot.model.dao;

import oneshot.model.dto.User;

public interface UserDao {
    User selectByEmail(String id);

    int insert(User user);

    User selectByUserId(int userId);

    int idCheck(String email);

    int update(User user);

    int delete(int userId);

}