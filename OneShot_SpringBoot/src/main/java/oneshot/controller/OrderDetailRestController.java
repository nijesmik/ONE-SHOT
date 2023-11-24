package oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @ApiOperation(value = "주문상세 추가")
    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        int result = orderDetailService.createOrderDetail(orderDetail);
        if (result == 0) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(orderDetail.getOrderDetailId(), HttpStatus.CREATED);
    }

    @GetMapping("/{orderDetailId}")
    @ApiOperation(value = "주문상세 조회")
    public ResponseEntity<?> selectOrderDetail(@PathVariable int orderDetailId) {
        OrderDetail orderDetail = orderDetailService.selectOrderDetail(orderDetailId);
        return new ResponseEntity<OrderDetail>(orderDetail, HttpStatus.OK);
    }

    @PatchMapping("/update/{orderDetailId}")
    @ApiOperation(value = "주문상세 수정")
    public ResponseEntity<?> updateOrderDetail(@PathVariable int orderDetailId, @RequestBody OrderDetail orderDetail) {
        int result = orderDetailService.updateOrderDetail(orderDetailId, orderDetail);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderDetailId}")
    @ApiOperation(value = "주문상세 삭제")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable int orderDetailId) {
        int result = orderDetailService.deleteOrderDetail(orderDetailId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}