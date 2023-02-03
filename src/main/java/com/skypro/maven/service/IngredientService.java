package com.skypro.maven.service;

import com.skypro.maven.model.Ingredient;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer id);
}
