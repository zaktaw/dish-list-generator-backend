package com.zaktaw.WebAppDishListGenerator.controllers;

import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import com.zaktaw.WebAppDishListGenerator.models.Dish;
import com.zaktaw.WebAppDishListGenerator.services.DishService;
import com.zaktaw.WebAppDishListGenerator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DishService dishService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
        return userService.register(appUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody AppUser appUser) {
        return userService.login(appUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Dish> addDishToUser(@PathVariable Integer userId, @RequestBody Dish dish, @RequestHeader("userAuthentication") String authorization) {
        return userService.addDishToUser(userId, authorization, dish);
    }

    @PutMapping("/removeDish/{userId}")
    public ResponseEntity<Dish> removeDishFromUser(@PathVariable Integer userId, @RequestBody Dish dish, @RequestHeader("userAuthentication") String authorization) {
        return userService.removeDishFromUser(userId, authorization, dish);
    }
}


