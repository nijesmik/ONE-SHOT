package oneshot.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oneshot.model.dto.Order;
import oneshot.model.dto.OrderDetail;
import oneshot.model.dto.User;
import oneshot.model.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
@Api(tags = "주문서 컨트롤러")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/regist")
    @ApiOperation(value = "주문서 생성", notes = "새로운 주문서 정보를 생성한다")
    public ResponseEntity<?> regist(HttpSession session) {
        Object userObject = session.getAttribute("loginUser");
        if (userObject == null || userObject == "") {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        User loginUser = (User) userObject;
        Order order = new Order();
        order.setUserId(loginUser.getUserId());

        String orderUrl = "http://localhost:8080/oneshot/order/";
        while (true) {
            Random rnd = new Random();
            StringBuffer buf = new StringBuffer();

            for (int i = 0; i < 10; i++) {
                if (rnd.nextBoolean()) {
                    buf.append((char) ((int) (rnd.nextInt(26)) + 97));
                } else {
                    buf.append((rnd.nextInt(10)));
                }
            }
            String randomUrl = buf.toString();
            int check = orderService.urlCheck(orderUrl + randomUrl);
            if (check < 1) {
                orderUrl += randomUrl;
                order.setOrderUrl(orderUrl);
                break;
            }
        }

        int result = orderService.regist(order);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @PostMapping("/detail/add")
    @ApiOperation(value = "주문 추가", notes = "새로운 주문을 추가한다")
    public ResponseEntity<?> addOrderDetail(OrderDetail orderDetail) {
        int result = orderService.addOrderDetail(orderDetail);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

}