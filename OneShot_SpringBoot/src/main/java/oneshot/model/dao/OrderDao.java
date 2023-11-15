package oneshot.model.dao;

import oneshot.model.dto.Order;
import oneshot.model.dto.OrderDetail;

public interface OrderDao {
    int registOrder(Order order);

    int urlCheck(String url);

    int addOrderDetail(OrderDetail orderDetail);
}