package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, name = "preparationTime")
    private double preparationTime;


    @Column(nullable = true, name = "photoUrl")
    private String photoUrl;

    @OneToMany(mappedBy = "recipe")
    private Set<Review> reviews=new HashSet<>();

    @OneToMany(mappedBy = "recipe")
    private Set<Instruction> instructions=new HashSet<>();

    @OneToMany(mappedBy = "recipe")
    private List<IngredientRecipe> ingredientRecipeList;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public String getCategoryName(){return getCategory().getCategoryName();}
    public String getUserName(){return getUser().getFirstName();}

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

    public double getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(double preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Instruction> instructions) {
        this.instructions = instructions;
    }




    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<IngredientRecipe> getIngredientRecipeList() {
        return ingredientRecipeList;
    }

    public void setIngredientRecipeList(List<IngredientRecipe> ingredientRecipeList) {
        this.ingredientRecipeList = ingredientRecipeList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
