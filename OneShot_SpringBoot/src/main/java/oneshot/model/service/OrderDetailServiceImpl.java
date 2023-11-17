package oneshot.model.service;

import java.util.List;
import oneshot.model.dao.OrderDetailDao;
import oneshot.model.dto.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Transactional
    @Override
    public int createOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.createOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> getOrderDetails(int orderId) {
        return orderDetailDao.selectByOrderId(orderId);
    }
  
    @Override
    public OrderDetail selectOrderDetail(int orderDetailId) {
        return orderDetailDao.selectOrderDetail(orderDetailId);
    }

    @Override
    public int updateOrderDetail(int orderDetailId, OrderDetail orderDetail) {
        orderDetail.setOrderDetailId(orderDetailId);
        return orderDetailDao.updateOrderDetail(orderDetail);
    }

    @Override
    public int deleteOrderDetail(int orderDetailId) {
        return orderDetailDao.deleteOrderDetail(orderDetailId);
    }
}
