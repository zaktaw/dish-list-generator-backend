package com.zaktaw.WebAppDishListGenerator.controllers;

import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import com.zaktaw.WebAppDishListGenerator.models.Dish;
import com.zaktaw.WebAppDishListGenerator.services.DishService;
import com.zaktaw.WebAppDishListGenerator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody AppUser appUser) {
        return userService.register(appUser);
    }

    @PutMapping("/{userId}")
    public Optional<AppUser> addDishToUser(@PathVariable Integer userId, @RequestBody Dish dish) {

        System.out.println("Printing tags");
        for (String tag : dish.getTags()) {
            System.out.println(tag);
        }

        /*System.out.println("Printing tags");
        for (String tag : dish.getIngredients()) {
            System.out.println(tag);
        }*/

        dishService.addDish(dish);
        return userService.addDishToUser(userId, dish);
    }
}


