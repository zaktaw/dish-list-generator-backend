package com.zaktaw.WebAppDishListGenerator.repositories;

import com.zaktaw.WebAppDishListGenerator.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
