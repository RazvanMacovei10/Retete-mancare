package com.spring.macoveirazvanionut.repositories;

import com.spring.macoveirazvanionut.entities.Category;
import com.spring.macoveirazvanionut.entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

    @Query("SELECT r from Recipe r inner join r.category c on c.id=r.category.id inner join r.user u on u.id=r.user.id")
    Collection<Recipe> findAllRecipes();

    @Query("SELECT r from Recipe r where r.user.id=?1")
    Collection<Recipe> findAllUserRecipes(Integer id);

}
