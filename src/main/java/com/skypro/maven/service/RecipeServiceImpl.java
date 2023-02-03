package com.skypro.maven.service;

import com.skypro.maven.model.Recipe;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl {
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private static Integer id = 0;




    public Recipe addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
        return recipe;
    }

    public Recipe getRecipe(Integer id) {
        return recipeMap.getOrDefault(id, null);
    }
}
