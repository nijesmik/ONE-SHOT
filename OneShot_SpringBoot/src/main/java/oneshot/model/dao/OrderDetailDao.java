package oneshot.model.dao;

import oneshot.model.dto.OrderDetail;

public interface OrderDetailDao {
    int createOrderDetail(OrderDetail orderDetail);
}