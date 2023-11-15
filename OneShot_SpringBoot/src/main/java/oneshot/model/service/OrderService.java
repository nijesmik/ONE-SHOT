package oneshot.model.service;

import oneshot.model.dto.Order;

public interface OrderService {
    int regist(Order order);

    int urlCheck(String url);
}