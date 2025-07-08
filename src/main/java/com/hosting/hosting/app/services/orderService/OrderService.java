package com.hosting.hosting.app.services.orderService;

import java.util.List;

import com.hosting.hosting.app.model.Cart;
import com.hosting.hosting.app.model.Order;

public interface OrderService {
    Order readOrdersData(String email);
    void postOrderDetail(Order order);
    void  deleteOrder(Order order);
    


}
