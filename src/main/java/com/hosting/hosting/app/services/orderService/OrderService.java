package com.hosting.hosting.app.services.orderService;

import java.util.List;

import com.hosting.hosting.app.model.Order;

public interface OrderService {
    List<Order> readCartData(String email);
    List<Order> readOrdersData(String email);
    

}
