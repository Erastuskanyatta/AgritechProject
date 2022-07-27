package com.example.agritech.WebApp.Services;

import com.example.agritech.WebApp.APIs.CartController;
import com.example.agritech.WebApp.Model.Cart;
import com.example.agritech.WebApp.Repository.CartRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServices {
    public CartController cartController;
    public final CartRepo cartRepo;

    public CartServices(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }
    public Cart shop(Cart cart) {

        return cartRepo.save(cart);
    }
    public static List<Cart> Cart(Cart cart) {
        return Cart(cart);
    }
    public void deleteProductCartById(Long cartId) {
        cartRepo.deleteById(cartId);
    }
}

