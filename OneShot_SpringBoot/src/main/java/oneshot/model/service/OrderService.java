package oneshot.model.service;

import oneshot.model.dto.Order;

public interface OrderService {
    int createOrder(Order order);

    int urlCheck(String url);

}