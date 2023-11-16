package oneshot.model.dao;

import oneshot.model.dto.Order;

public interface OrderDao {
    int createOrder(Order order);

    int urlCheck(String url);
}