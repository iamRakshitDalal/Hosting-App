package com.hosting.hosting.app.services.cartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.hosting.hosting.app.entities.CartEntity;
import com.hosting.hosting.app.model.Cart;
import com.hosting.hosting.app.repository.CartRepository;

public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    
    @Override
    public String addproduct(Cart cart) {
        Optional<CartEntity> optional = cartRepository.findByEmail(cart.getEmail());
        if(optional.isPresent()){
            CartEntity cartEntity = optional.get();
            Map<String,List<String>> domainDetails = cartEntity.getDomianDetails();
            List<String> lst = new ArrayList<>();
            lst.add(cart.getDomainPricePerYear()+"");
            lst.add(cart.getRentForTime()+"");
            domainDetails.put(cart.getDomianName(),lst);
            cartEntity.setDomianDetails(domainDetails);
            cartRepository.save(cartEntity);
            return "Done";
        }
        return "Not Found";
        

    }

    @Override
    public List<Cart> readCartProduct(String email) {
        Optional<CartEntity> optional = cartRepository.findByEmail(email);
        if(optional.isPresent()){
            CartEntity cartEntity = optional.get();
            List<Cart> lst = new ArrayList<>();
            for(Map.Entry<String,List<String>> i : cartEntity.getDomianDetails().entrySet()){
               lst.add(new Cart(email,i.getKey(),Float.parseFloat(i.getValue().get(0)),Integer.parseInt(i.getValue().get(1))));
            }
            return lst;
        }
        return null;
        
    }

    

    @Override
    public String deleteCart(Cart cart) {
        Optional<CartEntity> optional = cartRepository.findByEmail(cart.getEmail());
        if(optional.isPresent()){
            CartEntity cartEntity = optional.get();
            Map<String,List<String>> domainDetails = cartEntity.getDomianDetails();
            domainDetails.remove(cart.getDomianName());
            cartEntity.setDomianDetails(domainDetails);
            cartRepository.save(cartEntity);
            return "Done";
        }
        return "Not Found";
        
    }
    
}
