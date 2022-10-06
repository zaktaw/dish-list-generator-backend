package com.zaktaw.WebAppDishListGenerator.controllers;

import com.azure.core.annotation.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping
    public boolean register(String username, String password) {
        return true;
    }

    @GetMapping
    @RequestMapping
    public boolean login(String username, String password) {
        return true;
    }
}


