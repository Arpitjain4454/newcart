package com.arpit.cart.controller;

import com.arpit.cart.model.Cart;
import com.arpit.cart.service.CartService;
import com.arpit.cart.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/{cartId}")
    public Cart createCart(@PathVariable Long cartId) throws ResourceNotFoundException {
        return cartService.getCartById(cartId);
    }

    @PutMapping("/{cartId}")
    public Cart updateCart(@PathVariable Long cartId, @RequestBody Cart cart) throws ResourceNotFoundException {
        return cartService.updateCart(cartId, cart);
    }
}
