package oneshot.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oneshot.model.dao.OrderDao;
import oneshot.model.dto.Order;
import oneshot.model.dto.User;
import oneshot.util.RandomCode;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public String createOrder(User user, String brandId) {
        String orderCode = createOrderCode();
        int userId = user.getUserId();
        Order order = new Order(Integer.parseInt(brandId), userId, orderCode);
        int result = orderDao.insert(order);
        if (result == 0) {
            return null;
        }
        return orderCode;
    }

    @Override
    public String createOrderCode() {
        while (true) {
            String randomCode = RandomCode.get();
            if (orderDao.countByOrderCode(randomCode) == 0) {
                return randomCode;
            }
        }
    }

    @Override
    public Order getOrder(String orderCode) {
        return orderDao.selectByOrderCode(orderCode);
    }

    @Override
    public int updateOrder(int orderId, Order order) {
        order.setOrderId(orderId);
        return orderDao.update(order);
    }

    @Override
    public int deleteOrder(int orderId) {
        return orderDao.delete(orderId);
    }

}
