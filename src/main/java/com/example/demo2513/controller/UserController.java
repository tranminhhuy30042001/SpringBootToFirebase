package com.example.demo2513.controller;

import com.example.demo2513.entity.User;
import com.example.demo2513.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService procedureService;

    @PostMapping("/users")
    public String saveUser(@RequestBody User product) throws ExecutionException, InterruptedException {
        return procedureService.saveProcedure(product);
    }

    @GetMapping("/users/{name}")
    public User getUser(@PathVariable String name) throws ExecutionException, InterruptedException {
        return procedureService.getUserDetailByname(name);
    }
    @GetMapping("/users")
    public List<User> getAllUser() throws ExecutionException, InterruptedException {
        return procedureService.getUserDetail();
    }

    @PutMapping("/users")
    public String update(@RequestBody User product) throws ExecutionException, InterruptedException {
        return procedureService.updateProcedure(product);
    }

    @DeleteMapping("/users/{name}")
    public String deleteUser(@PathVariable String name) throws ExecutionException, InterruptedException {
        return procedureService.deleteProcedure(name);
    }
}
