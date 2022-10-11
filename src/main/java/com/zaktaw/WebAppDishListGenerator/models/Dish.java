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

    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private List<String> ingredients;

    public Dish() {
    }

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

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
