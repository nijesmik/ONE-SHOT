package oneshot.model.dao;

import oneshot.model.dto.OrderDetail;

public interface OrderDetailDao {
    int createOrderDetail(OrderDetail orderDetail);

    OrderDetail selectOrderDetail(int orderDetailId);

    int updateOrderDetail(OrderDetail orderDetail);

    int deleteOrderDetail(int orderDetailId);

}