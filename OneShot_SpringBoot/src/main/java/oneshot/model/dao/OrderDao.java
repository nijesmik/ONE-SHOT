package oneshot.model.dao;

import oneshot.model.dto.Order;

public interface OrderDao {
    int insert(Order order);

    int countByOrderCode(String orderCode);

    Order selectByOrderCode(String orderCode);

    int delete(int orderId);
}