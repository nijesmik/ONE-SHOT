package oneshot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oneshot.model.dto.Order;
import oneshot.model.dto.OrderDetail;
import oneshot.model.dto.User;
import oneshot.model.service.OrderDetailService;
import oneshot.model.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
@Api(tags = "주문서 컨트롤러")
public class OrderRestController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/create")
    @ApiOperation(value = "주문서 생성")
    public ResponseEntity<?> createOrder(HttpSession session, @RequestParam String brandId, @RequestParam int userId) {
//        Object userObject = session.getAttribute("loginUser");
//        if (userObject == null || userObject == "") {
//            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
//        }
//
//        User user = (User) userObject;

        User user = new User();
        user.setUserId(userId);

        String orderCode = null;
        try {
            orderCode = orderService.createOrder(user, brandId);
        } catch (NumberFormatException e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if (orderCode == null) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(orderCode, HttpStatus.CREATED);
    }

    @GetMapping()
    @ApiOperation(value = "주문서 조회")
    private ResponseEntity<?> getOrder(@RequestParam String orderCode) {
        Order order = orderService.getOrder(orderCode);
        List<OrderDetail> orderDetails = orderDetailService.getOrderDetails(order.getOrderId());
        if (order == null || orderDetails == null) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderDetail", orderDetails);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @PatchMapping("/update/{orderId}")
    @ApiOperation(value = "주문서 수정")
    public ResponseEntity<?> updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        int result = orderService.updateOrder(orderId, order);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{order_id}")
    @ApiOperation(value = "주문서 삭제")
    private ResponseEntity<?> deleteOrder(@PathVariable(name = "order_id") int orderId) {
        int result = orderService.deleteOrder(orderId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}