package com.zaktaw.WebAppDishListGenerator.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class AppUser {
    @Id
    @SequenceGenerator(name = "app_user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_sequence")
    private Integer id;
    private String username;
    private String password;

    //@JsonIgnore
    @OneToMany(targetEntity = Dish.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user_dish_foreign_key", referencedColumnName = "id") // "id" is referencing AppUser's id
    private List<Dish> dishes = new ArrayList<>();

    public AppUser() {
    }

    public AppUser(Integer id, String username, String password, List<Dish> dishes) {
        this.id = id;
        this.username = username;
        this.password = password;
       this.dishes = dishes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    @Override
    public String toString() {
        return id + ": " + username;
    }
}
