package com.skypro.maven.service;

import com.skypro.maven.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class IngredientServiceImpl {
    private final Map<Integer, Integer> ingredientMap = new HashMap<>();
    private static Integer id = 0;


    public Ingredient addIngredient(Ingredient ingredient) {
        ingredientMap.put(id++, ingredient.getCount());
        return ingredient;
    }

    public Integer getIngredient(Integer id) {
        return ingredientMap.getOrDefault(id, null);
    }
}
