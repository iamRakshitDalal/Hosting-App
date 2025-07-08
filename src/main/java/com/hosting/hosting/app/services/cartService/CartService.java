package com.hosting.hosting.app.services.cartService;

import java.util.ArrayList;

import com.hosting.hosting.app.model.Cart;

public interface CartService {
    String addproduct(Cart cart);
    ArrayList<Cart> readCartProduct(String email);
    String cartUpdateProduct(Cart cart);
    String deleteCart(Cart cart);
}
