package com.spring.macoveirazvanionut.repositories;

import com.spring.macoveirazvanionut.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {
}
