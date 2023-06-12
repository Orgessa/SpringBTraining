package com.dbexamples.queryingandmodifyingdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class QueryingAndModifyingDbApplication {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(QueryingAndModifyingDbApplication.class, args);

        RecipeService service = context.getBean(RecipeService.class);



        // A:  Get recipe count
        Long count = service.getRecipeCount();
        System.out.println("*******************");
        System.out.println("** A: getRecipeCount " + count);


        Recipe recipe = service.getRecipe(2);
        System.out.println("*******************");
        System.out.println("** B: getRecipe " + recipe);


        List<Recipe> recipes = service.getRecipes();
        System.out.println("*******************");
        System.out.println("** C: getRecipes " + recipes);

        Recipe newRecipe = new Recipe(-1, "bacon");
        service.addNewRecipe(newRecipe);
        System.out.println("*******************");
        System.out.println("** D: insertRecipes " + service.getRecipes() );

    }
    
 



}
