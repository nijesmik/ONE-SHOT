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
    public User login(User user) {
        User tmp = userDao.selectOne(user.getEmail());
        if (tmp != null && tmp.getPassword().equals(user.getPassword()))
            return tmp;
        return null;
    }

    @Transactional
    @Override
    public int signup(User user) {
        return userDao.insertUser(user);
    }
}
