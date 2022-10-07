package com.zaktaw.WebAppDishListGenerator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Tag {
    @Id
    @SequenceGenerator(name = "tag_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
    private Integer id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
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
