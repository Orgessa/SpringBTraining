package demo.pv10springdatarepositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Pv10SpringDataRepositoriesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Pv10SpringDataRepositoriesApplication.class, args);
        RecipeService service  = context.getBean(RecipeService.class);
        CafeUserService cafeService  = context.getBean(CafeUserService.class);

        // A:  Get recipe count
        long count = service.getRecipeCount();
        System.out.println("*******************");
        System.out.println("** A: getRecipeCount " + count);

        // B: Get Recipe
        System.out.println("*******************");
        System.out.println("** B: getRecipe " + service.getRecipe(2).orElseThrow());

        // C: Get all recipes
        List<Recipe> recipes = service.getRecipes();
        System.out.println("*******************");
        System.out.println("** C: getRecipes ");
        service.getRecipes().forEach(System.out::println);

        // D: insert Recipe
        Recipe newRecipe = new Recipe(-1, "Scrambled eggs", "NONVEG" , "LOW" );
        service.insertRecipe(newRecipe);
        System.out.println("*******************");
        System.out.println("** D: insertRecipes ");
        service.getRecipes().forEach(System.out::println);

        // E: update Recipe
        service.updateRecipe(1L, "Chicken Tikka Masala superior");
        System.out.println("*******************");
        System.out.println("** E: updateRecipes " );
        service.getRecipes().forEach(System.out::println);

        // F: delete Recipe
        service.deleteRecipe(2L);
        System.out.println("*******************");
        System.out.println("** F: deleteRecipes " );
        service.getRecipes().forEach(System.out::println);

        // G: update using jpql with parameters
        int rowsAffected = service.updateSpiceLevel("NONVEG", "HIGH");
        System.out.println("*******************");
        System.out.println("** G:  update using jpql with parameters" );
        System.out.println("Rows affected : " + rowsAffected);
        service.getRecipes().forEach(System.out::println);

        // A:  Get user count
        long countUser = cafeService.getUserCount();
        System.out.println("*******************");
        System.out.println("** A: getUserCount " + countUser);

        // B: Get User
        System.out.println("*******************");
        System.out.println("** B: getUser " + cafeService.getUser(2).orElseThrow());


        // C: Get all users
        List<CafeUser> users = cafeService.getUsers();
        System.out.println("*******************");
        System.out.println("** C: getUsers ");
        cafeService.getUsers().forEach(System.out::println);

        // D: insert User
        CafeUser cafeUser = new CafeUser(-1, "user102" );
        cafeService.insertUser(cafeUser);
        System.out.println("*******************");
        System.out.println("** D: insertUser ");
        cafeService.getUsers().forEach(System.out::println);


        // E: update User
        cafeService.updateUser(1L, "user103");
        System.out.println("*******************");
        System.out.println("** E: updateUser " );
        cafeService.getUsers().forEach(System.out::println);

        // F: delete User
        cafeService.deleteUser(2L);
        System.out.println("*******************");
        System.out.println("** F: deleteUser" );
        cafeService.getUsers().forEach(System.out::println);


        //G: update username

        int rowsAffected1= cafeService.updateUsername(4L,"user119");
        System.out.println("Rows affected : " + rowsAffected1);
        cafeService.getUsers().forEach(System.out::println);
    }

}
