package oneshot.model.service;

import oneshot.model.dto.Order;
import oneshot.model.dto.User;

public interface OrderService {
    String createOrder(User user, String brandId);

    String createOrderCode();

    Order getOrder(String orderCode);

    int updateOrder(int orderId, Order order);

    int deleteOrder(int orderId);
}