package com.hosting.hosting.app.services.orderService;

import java.util.List;
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
    private CartRepository cartRepository;
    
    OrderServiceImpl(OrderRepository orderRepository,CartRepository cartRepository){
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Cart readCartData(String email) {
        Optional<CartEntity> optional = cartRepository.findByEmail(email);
        if(optional.isPresent()){
            CartEntity cartEntity = optional.get();
            Cart cart = new Cart();
            BeanUtils.copyProperties(cartEntity,cart);
            return cart;
        }
        return null;
    }
    @Override
    public void postCartDetail(Cart cart){
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(cart,cartEntity);
        cartRepository.save(cartEntity);
        
    }
 
    @Override
    public Order readOrdersData(String email) {
        Optional<OrderEntity> optional = orderRepository.findByEmail(email);
        if(optional.isPresent()){
            OrderEntity  orderEntity = optional.get();
            Order order = new Order();
            BeanUtils.copyProperties(orderEntity,order);
            return order;
        }
        return null;
    }

    @Override
    public void postOrderDetail(Order order) {
        OrderEntity  orderEntity  = new OrderEntity();
        BeanUtils.copyProperties(order,orderEntity);
        orderRepository.save(orderEntity);
    }

    @Override
    public void deleteOrder(Order order) {
         Optional<OrderEntity> optional = orderRepository.findById(order.getOrderId());
        if(optional.isPresent()){
            OrderEntity  orderEntity = optional.get();
            orderRepository.delete(orderEntity);
        }
    }       
    @Override
    public void deleteCart(Cart cart) {
        Optional<CartEntity> optional = cartRepository.findByEmail(cart.getEmail());
        if(optional.isPresent()){
            CartEntity cartEntity = optional.get();
            cartRepository.delete(cartEntity);
        }
    } 

    
}
