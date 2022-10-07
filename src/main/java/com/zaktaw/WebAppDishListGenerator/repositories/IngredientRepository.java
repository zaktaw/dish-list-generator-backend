package com.zaktaw.WebAppDishListGenerator.repositories;

import com.zaktaw.WebAppDishListGenerator.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
