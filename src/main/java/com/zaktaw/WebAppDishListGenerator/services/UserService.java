package com.zaktaw.WebAppDishListGenerator.services;

import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import com.zaktaw.WebAppDishListGenerator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> register(AppUser appUser) {
        AppUser appUserFromDb = userRepository.findByEmail(appUser.getEmail());

        // user exists
        if (appUserFromDb != null) {
            return new ResponseEntity<>("Email is already registered", HttpStatus.BAD_REQUEST);
        }

        // user does not exist -> register new user
        else {
            userRepository.save(appUser);
            return new ResponseEntity<>("User registered", HttpStatus.ACCEPTED);
        }

    }
}
