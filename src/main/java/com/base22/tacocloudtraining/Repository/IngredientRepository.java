package com.base22.tacocloudtraining.Repository;


import com.base22.tacocloudtraining.Model.Ingredient;


import org.springframework.data.repository.CrudRepository;
public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}