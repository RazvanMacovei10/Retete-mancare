package com.spring.macoveirazvanionut.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IngredientRecipesPK implements Serializable {
    @Column(name="Recipe_id")
    private int recipeId;
    @Column(name="ingredient_id")
    private int ingredientId;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}
