package oneshot.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oneshot.model.dao.UserDao;
import oneshot.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User inputUser) {
        User savedUser = userDao.selectByEmail(inputUser.getEmail());
        if (savedUser != null && savedUser.ComparePassword(inputUser)) {
            return savedUser;
        }
        return null;
    }

    @Transactional
    @Override
    public int signup(User user) {
        return userDao.insert(user);
    }

    @Override
    public int idCheck(String email) {
        return userDao.idCheck(email);
    }

    @Override
    public int updateUser(User user, int userId) {
        User originalUserData = userDao.selectByUserId(userId);
        user.importData(userId, originalUserData);
        return userDao.update(user);
    }

    @Override
    public int deleteUser(int userId) {
        return userDao.delete(userId);
    }

}
