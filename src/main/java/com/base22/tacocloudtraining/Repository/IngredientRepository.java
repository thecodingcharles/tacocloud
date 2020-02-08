package com.base22.tacocloudtraining.Repository;


import com.base22.tacocloudtraining.Model.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

}