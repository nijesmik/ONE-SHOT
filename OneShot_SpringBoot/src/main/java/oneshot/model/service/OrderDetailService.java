package oneshot.model.service;

import java.util.List;
import oneshot.model.dto.OrderDetail;

public interface OrderDetailService {

    int createOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetails(int orderId);
}