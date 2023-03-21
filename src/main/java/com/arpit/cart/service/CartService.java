package com.arpit.cart.service;

import com.arpit.cart.model.Cart;
import com.arpit.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService {

    @Autowired
    CartRepository cartRepository;
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long cartId) throws ResourceNotFoundException {
        return cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart", "cartId", cartId));
    }

    public Cart updateCart(Long cartId, Cart cart) throws ResourceNotFoundException {
        Cart existingCart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart", "cartId", cart.getCartId()));

    }
}
