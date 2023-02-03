package com.skypro.maven.service;

import com.skypro.maven.model.Recipe;

public interface RecipeService {
    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);
}
