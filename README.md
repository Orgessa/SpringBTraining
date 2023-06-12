# SpringBTraining

# Assignment:

1-Try making the following changes to the code and see the effects
Interchange getSingleResult() and getResultList() and see the effects. You'll also have to make changes to the code so that you don't have compilation errors.
2-Remove the @Transactional annotation and see the effects.

1)
 public long getRecipeCount() {
        String jpql = "select count(r) from Recipe r";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        return query.getSingleResult();
    }

changed to:

public List<Long> getRecipeCount() {
        String jpql = "select count(r) from Recipe r";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        return query.getResultList();
    }

-After changing the method from getSingleResult to getResultList, I had to also change the return type of the getRecipeCount 
 from Long to List<Long> in order to avoid compilation errors. I changed that on the service class also on the main application. 
 After running the application with the new changes it works normally and it does return the correct value as an element of a list. 

 public List<Recipe> getRecipes() {
        String jpql = "select r from Recipe r";
        TypedQuery<Recipe> query = entityManager.createQuery(jpql, Recipe.class);
        return query.getResultList();
    }

changed to:

public List<Recipe> getRecipes() {
        String jpql = "select r from Recipe r";
        TypedQuery<Recipe> query = entityManager.createQuery(jpql, Recipe.class);
        return (List <Recipe>)query.getSingleResult();

-After changing the method from getResultList to getSingleResult, I also put (List <Recipe>) in front of query.getSingleResult(); to make
 the result of query.getSingleResult(); into the List <Recipe> type to match the return type of the getRecipes method.
 After running the app it gives an error: query did not return a unique result: 3
 

 2)
@Transactional
public void addNewRecipe(Recipe recipe){
        entityManager.persist(recipe);2
    }

-After removing the annotation from the addNewRecipe method I had an error: No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call
 and the new recipe was not added into the DB.


