package oneshot.model.service;

import oneshot.model.dto.Order;
import oneshot.model.dto.User;

public interface OrderService {
    int createOrder(User user, String orderCode);

    String createOrderCode();

    Order getOrder(String orderCode);

    int deleteOrder(int orderId);
}