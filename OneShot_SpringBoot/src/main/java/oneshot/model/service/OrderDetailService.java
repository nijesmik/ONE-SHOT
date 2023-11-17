package oneshot.model.service;

import oneshot.model.dto.OrderDetail;

public interface OrderDetailService {

    int createOrderDetail(OrderDetail orderDetail);

    OrderDetail selectOrderDetail(int orderDetailId);

    int updateOrderDetail(int orderDetailId, OrderDetail orderDetail);

    int deleteOrderDetail(int orderDetailId);
}