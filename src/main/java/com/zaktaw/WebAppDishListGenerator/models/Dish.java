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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private List<String> ingredients;

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
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

   /* public List<String> getIngredients() {
        return ingredients;
    }*/
}
