package com.hosting.hosting.app.services.cartService;
import java.util.List;

import com.hosting.hosting.app.model.Cart;

public interface CartService {
    String addproduct(Cart cart);
    List<Cart> readCartProduct(String email);
    String deleteCart(Cart cart);
}
