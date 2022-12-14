package com.example.demo2513.controller;

import com.example.demo2513.entity.Product;
import com.example.demo2513.service.ProcedureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProcedureService procedureService;

    @PostMapping("/product")
        public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return procedureService.saveProcedure(product);
    }

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
        return procedureService.getProductDetailByname(name);
    }
    @GetMapping("/product")
    public List<Product> getAllProduct() throws ExecutionException, InterruptedException {
        return procedureService.getProductDetail();
    }

    @PutMapping("/product")
    public String update(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return procedureService.updateProcedure(product);
    }

    @DeleteMapping("/product/{name}")
    public String deleteProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
        return procedureService.deleteProcedure(name);
    }
}
