package com.zaktaw.WebAppDishListGenerator.repositories;

import com.zaktaw.WebAppDishListGenerator.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
}