package com.zaktaw.WebAppDishListGenerator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Ingredient {
    @Id
    @SequenceGenerator(name = "ingredient_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_sequence")
    private Integer id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
