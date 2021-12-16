package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;
import java.util.List;
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


    @OneToMany(mappedBy = "ingredient")
    private List<IngredientRecipe> ingredientRecipeList;



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



    public List<IngredientRecipe> getIngredientRecipeList() {
        return ingredientRecipeList;
    }

    public void setIngredientRecipeList(List<IngredientRecipe> ingredientRecipeList) {
        this.ingredientRecipeList = ingredientRecipeList;
    }
}