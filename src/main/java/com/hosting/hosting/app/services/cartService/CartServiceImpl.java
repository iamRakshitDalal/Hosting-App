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
            return "Done";
        }
        return "Not Found";
        

    }

    @Override
    public ArrayList<Cart> readCartProduct(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readCartProduct'");
    }

    @Override
    public String cartUpdateProduct(Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cartUpdateProduct'");
    }

    @Override
    public String deleteCart(Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCart'");
    }
    
}
