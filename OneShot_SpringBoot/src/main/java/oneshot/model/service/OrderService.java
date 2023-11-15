package oneshot.model.service;

import oneshot.model.dto.Order;
import oneshot.model.dto.OrderDetail;

public interface OrderService {
    int regist(Order order);

    int urlCheck(String url);

    int addOrderDetail(OrderDetail orderDetail);
}