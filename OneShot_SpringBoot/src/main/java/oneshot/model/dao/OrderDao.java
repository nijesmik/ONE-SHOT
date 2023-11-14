package oneshot.model.dao;

import oneshot.model.dto.Order;

public interface OrderDao {
    int registOrder(Order order);
}