package com.spring.macoveirazvanionut.repositories;

import com.spring.macoveirazvanionut.entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

    @Query("SELECT r from Recipe r inner join Category c on r.id=c.id")
    Collection<Recipe> findAllRecipes();
}
