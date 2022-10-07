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

    @ManyToOne
    @JoinColumn(name="appUser_id", referencedColumnName = "id")
    private AppUser appUser;

    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private List<String> ingredients;

   /* @ManyToMany
    @JoinTable(name="ingredients_in_dishes",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;
    @ManyToMany
    @JoinTable(name="tags_in_dishes",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;*/

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }*/

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
