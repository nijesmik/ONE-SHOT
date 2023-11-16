package oneshot.model.service;

import oneshot.model.dto.Order;
import oneshot.model.dto.User;

public interface OrderService {
    int createOrder(User user, String url);

    String generateRandomUrl();
}