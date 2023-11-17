package oneshot.model.dao;

import java.util.List;
import oneshot.model.dto.OrderDetail;

public interface OrderDetailDao {
    int createOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> selectByOrderId(int orderId);
}