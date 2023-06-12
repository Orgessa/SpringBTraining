package com.dbexamples.queryingandmodifyingdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository repository;

    public Long getRecipeCount(){
        return repository.getRecipeCount();
    }

    public Recipe getRecipe(long recipeId) {
        return repository.getRecipe(recipeId);
    }

    public List<Recipe> getRecipes() {
        return repository.getRecipes();
    }

    public void addNewRecipe(Recipe recipe){
        repository.addNewRecipe(recipe);
    }
}

