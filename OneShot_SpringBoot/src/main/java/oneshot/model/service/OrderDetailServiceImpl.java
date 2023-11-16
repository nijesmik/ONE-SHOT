package oneshot.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oneshot.model.dao.OrderDetailDao;
import oneshot.model.dto.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Transactional
    @Override
    public int createOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.createOrderDetail(orderDetail);
    }

}
