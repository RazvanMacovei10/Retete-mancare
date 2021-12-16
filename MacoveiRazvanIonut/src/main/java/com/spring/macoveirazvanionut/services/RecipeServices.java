package com.spring.macoveirazvanionut.services;

import com.spring.macoveirazvanionut.entities.Recipe;
import com.spring.macoveirazvanionut.entities.User;
import com.spring.macoveirazvanionut.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RecipeServices {
    @Autowired
    private RecipeRepository recipeRepository;


    public List<Recipe> listAll()
    {
        return (List<Recipe>) recipeRepository.findAll();
    }

    public Collection<Recipe> listAllIncludingCategory()
    {
        return (Collection<Recipe>) recipeRepository.findAllRecipes();
    }

    public void save(Recipe recipe)  {
        recipeRepository.save(recipe);
    }
}
