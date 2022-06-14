package com.example.demo2513.controller;

import com.example.demo2513.entity.Sold;
import com.example.demo2513.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class SoldController {
    @Autowired
    private SoldService cartService;

    @PostMapping("/sold")
    public String saveSold(@RequestBody Sold cart) throws ExecutionException, InterruptedException {
        return cartService.saveProcedure(cart);
    }

    @GetMapping("/sold/{name}")
    public Sold getSold(@PathVariable String name) throws ExecutionException, InterruptedException {
        return cartService.getSoldDetailByname(name);
    }
    @GetMapping("/sold")
    public List<Sold> getAllSold() throws ExecutionException, InterruptedException {
        return cartService.getSoldDetail();
    }

    @PutMapping("/sold")
    public String update(@RequestBody Sold cart) throws ExecutionException, InterruptedException {
        return cartService.updateProcedure(cart);
    }

    @DeleteMapping("/sold/{name}")
    public String deleteSold(@PathVariable String name) throws ExecutionException, InterruptedException {
        return cartService.deleteProcedure(name);
    }
}
