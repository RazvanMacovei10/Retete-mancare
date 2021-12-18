package com.spring.macoveirazvanionut.services;

import com.spring.macoveirazvanionut.entities.Category;
import com.spring.macoveirazvanionut.entities.Recipe;
import com.spring.macoveirazvanionut.repositories.CategoryRepository;
import com.spring.macoveirazvanionut.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> listAll()
    {
        return (List<Category>) categoryRepository.findAll();
    }
}
