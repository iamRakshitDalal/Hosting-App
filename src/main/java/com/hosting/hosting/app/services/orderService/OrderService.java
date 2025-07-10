package com.hosting.hosting.app.services.orderService;


import java.util.List;

import com.hosting.hosting.app.model.Order;

public interface OrderService {
    String addOrder(Order order);
    List<Order> readOrdersData(String email);
    void  deleteOrder(Order order);
    Order updateDomainDetails(Order order);
    


}
