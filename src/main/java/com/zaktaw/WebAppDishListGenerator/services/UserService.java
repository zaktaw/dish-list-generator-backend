package com.zaktaw.WebAppDishListGenerator.services;

import com.zaktaw.WebAppDishListGenerator.Utility.PasswordHashing;
import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import com.zaktaw.WebAppDishListGenerator.models.Dish;
import com.zaktaw.WebAppDishListGenerator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<AppUser> register(AppUser appUser)  {
        AppUser appUserFromDb = userRepository.findByUsername(appUser.getUsername());

        // user exists
        if (appUserFromDb != null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        // user does not exist -> register new user
        else {
            String hashedPassword = PasswordHashing.hashPassord(appUser.getPassword());
            appUser.setPassword(hashedPassword);
            userRepository.save(appUser);
            return new ResponseEntity<>(appUser, HttpStatus.CREATED);
        }

    }

    public ResponseEntity<Dish> addDishToUser(Integer userId, Dish dish) {
        AppUser user = userRepository.findById(userId).get();
        user.addDish(dish);
        userRepository.save(user);
        return new ResponseEntity(dish, HttpStatus.CREATED);
    }


    public ResponseEntity<AppUser> login(AppUser appUser) {
        AppUser userFromDb = userRepository.findByUsername(appUser.getUsername());
        if (userFromDb == null) return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        else {
            // check if password matches password in database
            String passwordHashed = PasswordHashing.hashPassord(appUser.getPassword());
            if (passwordHashed.equals(userFromDb.getPassword())) {
                return new ResponseEntity<>(userFromDb, HttpStatus.OK);
            }
            else return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Dish> removeDishFromUser(Integer userId, Dish dish) {
        AppUser user = userRepository.findById(userId).get();
        user.removeDish(dish);
        userRepository.save(user);
        return new ResponseEntity(dish, HttpStatus.OK);
    }
}
