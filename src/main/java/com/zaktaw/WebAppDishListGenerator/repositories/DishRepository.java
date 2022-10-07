package com.zaktaw.WebAppDishListGenerator.repositories;

import com.zaktaw.WebAppDishListGenerator.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
