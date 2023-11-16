package oneshot.model.service;

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
    public int createOrder(Order order) {
        return orderDao.createOrder(order);
    }

    @Override
    public int urlCheck(String url) {
        return orderDao.urlCheck(url);
    }

}
