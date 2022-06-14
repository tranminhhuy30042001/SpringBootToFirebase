package com.example.demo2513.controller;

import com.example.demo2513.entity.Cart;
import com.example.demo2513.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class SoldController {
    @Autowired
    private CartService cartService;

    @PostMapping("/sold")
    public String saveCart(@RequestBody Cart cart) throws ExecutionException, InterruptedException {
        return cartService.saveProcedure(cart);
    }

    @GetMapping("/sold/{name}")
    public Cart getCart(@PathVariable String name) throws ExecutionException, InterruptedException {
        return cartService.getCartDetailByname(name);
    }
    @GetMapping("/sold")
    public List<Cart> getAllCart() throws ExecutionException, InterruptedException {
        return cartService.getCartDetail();
    }

    @PutMapping("/sold")
    public String update(@RequestBody Cart cart) throws ExecutionException, InterruptedException {
        return cartService.updateProcedure(cart);
    }

    @DeleteMapping("/sold/{name}")
    public String deleteCart(@PathVariable String name) throws ExecutionException, InterruptedException {
        return cartService.deleteProcedure(name);
    }
}
