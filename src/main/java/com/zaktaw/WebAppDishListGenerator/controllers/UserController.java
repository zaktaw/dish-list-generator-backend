package com.zaktaw.WebAppDishListGenerator.controllers;

import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import com.zaktaw.WebAppDishListGenerator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody AppUser appUser) {
        return userService.register(appUser);
    }



   /* @GetMapping
    @RequestMapping
    public boolean login(String username, String password) {
        return true;
    }*/
}


