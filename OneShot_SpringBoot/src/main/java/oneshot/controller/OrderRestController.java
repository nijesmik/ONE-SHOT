package oneshot.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import oneshot.model.dto.User;
import oneshot.model.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/oneshot/order")
@Api(tags = "주문서 컨트롤러")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/regist")
    @ApiOperation(value = "주문서 생성", notes = "새로운 주문서 정보를 생성한다")
    public ResponseEntity<?> regist(Order order, HttpSession session) {
        Object userObject = session.getAttribute("loginUser");
        if (userObject == null || userObject == "") {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        User loginUser = (User) userObject;
        order.setUserId(loginUser.getId());

        // TODO url 생성 알고리즘 설계
        order.setOrderUrl("http://localhost:8080/oneshot/orderurltest");

        int totalPrice = 0;
        String orderList = order.getOrderList();
        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try {
            obj = jsonParser.parse(orderList);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        JSONArray jsonArr = (JSONArray) obj;
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonArr.get(i);
            JSONObject orderDetail = (JSONObject) jsonObj.get("order_detail");
            Iterator<String> iter = orderDetail.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                // TODO 개별 가격 크롤링 후 메뉴코드로 가격 설정하기
                int price = 0;
                switch (key) {
                case "americano":
                    price = 1000;
                    break;
                case "latte":
                    price = 2000;
                    break;
                case "ade":
                    price = 3000;
                    break;
                }
                totalPrice += price * Integer.parseInt(String.valueOf(orderDetail.get(key)));
            }
        }
        order.setTotalPrice(totalPrice);

        int result = orderService.regist(order);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

}