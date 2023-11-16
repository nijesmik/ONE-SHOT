package oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oneshot.model.dto.OrderDetail;
import oneshot.model.service.OrderDetailService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order-detail")
@Api(tags = "주문상세 컨트롤러")
public class OrderDetailRestController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/create")
    @ApiOperation(value = "주문 추가", notes = "새로운 주문을 추가한다")
    public ResponseEntity<?> addOrderDetail(OrderDetail orderDetail) {
        int result = orderDetailService.addOrderDetail(orderDetail);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }
}