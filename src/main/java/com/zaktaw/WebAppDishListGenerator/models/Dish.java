package com.zaktaw.WebAppDishListGenerator.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Dish {
    @Id
    @SequenceGenerator(name = "dish_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_sequence")
    private Integer id;
    private String name;
    private List<String> ingredients;
    private List<String> tags;

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
