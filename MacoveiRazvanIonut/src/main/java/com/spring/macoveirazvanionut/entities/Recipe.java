package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;
import java.util.HashSet;
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


    @OneToMany(targetEntity = Review.class,cascade = CascadeType.ALL)
    @JoinColumn(name="recipeId",referencedColumnName = "id")
    private Set<Review> reviews=new HashSet<>();

    @OneToMany(targetEntity = Instruction.class,cascade = CascadeType.ALL)
    @JoinColumn(name="recipeId",referencedColumnName = "id")
    private Set<Instruction> instructions=new HashSet<>();

    @ManyToMany(mappedBy = "recipes")
    private Set<Ingredient> ingredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Category category;

    public String getCategoryName(){return category.getCategoryName();}

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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
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
}
