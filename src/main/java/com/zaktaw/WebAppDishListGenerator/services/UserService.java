package com.zaktaw.WebAppDishListGenerator.services;

import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import com.zaktaw.WebAppDishListGenerator.models.Dish;
import com.zaktaw.WebAppDishListGenerator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<AppUser> register(AppUser appUser) {
        AppUser appUserFromDb = userRepository.findByEmail(appUser.getEmail());

        // user exists
        if (appUserFromDb != null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        // user does not exist -> register new user
        else {
            userRepository.save(appUser);
            return new ResponseEntity<>(appUser, HttpStatus.ACCEPTED);
        }

    }

    public ResponseEntity<AppUser> addDishToUser(Integer userId, Dish dish) {
        AppUser user = userRepository.findById(userId).get();
        user.addDish(dish);
        userRepository.save(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }


    public ResponseEntity<AppUser> login(AppUser appUser) {
        AppUser userFromDb = userRepository.findByEmail(appUser.getEmail());
        if (userFromDb == null) return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        else {
            // check if password matches password in database
            // TODO: implement hashing and salting
            if (appUser.getPassword().equals(userFromDb.getPassword())) {
                return new ResponseEntity<>(userFromDb, HttpStatus.OK);
            }
            else return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
}
