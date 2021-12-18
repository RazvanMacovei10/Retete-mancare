package com.spring.macoveirazvanionut.services;

import com.spring.macoveirazvanionut.entities.Ingredient;
import com.spring.macoveirazvanionut.entities.User;
import com.spring.macoveirazvanionut.repositories.IngredientRepository;
import com.spring.macoveirazvanionut.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServices {
    @Autowired
    private IngredientRepository ingredientRepository;



    public List<Ingredient> listAll(){
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
