package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;

@Entity(name="IngredientRecipe")
@Table(name="IngredientRecipe")
public class IngredientRecipe {
    @EmbeddedId
    private IngredientRecipesPK id;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("recipeId")
    private Recipe recipe;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("ingredientId")
    private Ingredient ingredient;

    @Column(name="quantity")
    private double quantity;

    public IngredientRecipesPK getId() {
        return id;
    }

    public void setId(IngredientRecipesPK id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
