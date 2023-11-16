package oneshot.model.service;

import oneshot.model.dto.User;
import oneshot.util.RandomUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oneshot.model.dao.OrderDao;
import oneshot.model.dto.Order;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public int createOrder(User user, String orderUrl) {
        int userId = user.getUserId();
        Order order = new Order(userId, orderUrl);
        return orderDao.createOrder(order);
    }

    @Override
    public String generateRandomUrl() {
        while (true) {
            String randomUrl = RandomUrl.get();
            if (orderDao.urlCheck(randomUrl) == 0) {
                return randomUrl;
            }
        }
    }

}
