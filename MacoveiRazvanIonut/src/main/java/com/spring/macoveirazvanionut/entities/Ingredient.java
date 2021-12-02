package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="name")
    private String ingredientName;

    @Column(name="state")
    private String ingredientState;

    @Column(name="quantity")
    private double ingredientQuantity;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Recipe> recipes;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientState() {
        return ingredientState;
    }

    public void setIngredientState(String ingredientState) {
        this.ingredientState = ingredientState;
    }

    public double getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(double ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}