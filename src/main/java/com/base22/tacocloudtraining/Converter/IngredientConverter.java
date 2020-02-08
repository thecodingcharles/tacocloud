package com.base22.tacocloudtraining.Converter;

import com.base22.tacocloudtraining.Model.Ingredient;
import com.base22.tacocloudtraining.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientConverter(IngredientRepository ingredientRepo) {

        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String source) {

        System.out.println("TRYING TO CONVERT....."+ source);
        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        for (Ingredient ingredient : ingredients) {

            // You may use equal() method
            if (ingredient.getId().equals(source))

                return ingredient;
        }

        return null;
    }

}