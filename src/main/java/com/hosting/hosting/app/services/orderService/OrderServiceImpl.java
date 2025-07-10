package com.hosting.hosting.app.services.orderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.hosting.hosting.app.entities.CartEntity;
import com.hosting.hosting.app.entities.OrderEntity;
import com.hosting.hosting.app.model.Cart;
import com.hosting.hosting.app.model.Order;
import com.hosting.hosting.app.repository.CartRepository;
import com.hosting.hosting.app.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    
    
    OrderServiceImpl(OrderRepository orderRepository,CartRepository cartRepository){
        this.orderRepository = orderRepository;
    }

   @Override
    public String addOrder(Order order) {
        Optional<OrderEntity> optional = orderRepository.findByEmail(order.getEmail());
        if(optional.isPresent()){
            OrderEntity  orderEntity = optional.get();
            Map<String,List<String>> domainDetails = orderEntity.getDomainDetails();
            List<String> lst = new ArrayList<>();
            lst.add(order.getPricePerYear()+"");
            lst.add(order.getExpireDate().toString());
            lst.add(order.getRenewPeriod().toString());
            domainDetails.put(order.getDomainName(),lst);
            orderEntity.setDomainDetails(domainDetails);
            orderRepository.save(orderEntity);
            return "Done";
        }
        return "Not Found";
    } 
    
 
    @Override
    public List<Order> readOrdersData(String email) {
        Optional<OrderEntity> optional = orderRepository.findByEmail(email);
        if(optional.isPresent()){
            OrderEntity  orderEntity = optional.get();
            List<Order> lst = new ArrayList<>();
            for(Map.Entry<String,List<String>> i : orderEntity.getDomainDetails().entrySet()){
               lst.add(updateDomainDetails(new Order(
                email,
                i.getKey(),
                Float.parseFloat(i.getValue().get(0)),
                LocalDate.parse(i.getValue().get(1)),
                LocalDate.parse(i.getValue().get(2))
                )));
            }
            return lst;
        }
        return null;
    }

    

    @Override
    public void deleteOrder(Order order) {
        Optional<OrderEntity> optional = orderRepository.findByEmail(order.getEmail());
        if(optional.isPresent()){
            OrderEntity  orderEntity = optional.get();
            orderEntity.getDomainDetails().remove(order.getDomainName());
            orderRepository.save(orderEntity);
        }
    }

    @Override
    public Order updateDomainDetails(Order order) {
        return order;
    }




          
 

    
}
