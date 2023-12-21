package dk.lyngby.dao.impl;

import dk.lyngby.model.Recipe;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class RecipeDao implements dk.lyngby.dao.IDao<Recipe, Integer> {

    private static RecipeDao instance;
    private static EntityManagerFactory emf;

    public static RecipeDao getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeDao();
        }
        return instance;
    }

    @Override
    public Recipe read(Integer integer) {
       try (var em = emf.createEntityManager())
       {
           return em.find(Recipe.class, integer);
       }
    }

    @Override
    public List<Recipe> readAll() {
        try (var em = emf.createEntityManager())
        {
            var query = em.createQuery("SELECT h FROM Recipe h", Recipe.class);
            return query.getResultList();
        }
    }

    @Override
    public Recipe create(Recipe recipe) {
        try (var em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(recipe);
            em.getTransaction().commit();
            return recipe;
        }
    }

    @Override
    public Recipe update(Integer id, Recipe updatedRecipe) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Recipe existingRecipe = em.find(Recipe.class, id);

            if (existingRecipe != null) {
                existingRecipe.setRecipeName(updatedRecipe.getRecipeName());
                existingRecipe.setRecipeImg(updatedRecipe.getRecipeImg());
                existingRecipe.setRecipeDescription(updatedRecipe.getRecipeDescription());
                existingRecipe.setRecipeType(updatedRecipe.getRecipeType());
                existingRecipe.setRecipePreptime(updatedRecipe.getRecipePreptime());
                existingRecipe.setRecipeIngredients(updatedRecipe.getRecipeIngredients());
                existingRecipe.setRecipeDirections(updatedRecipe.getRecipeDirections());

                Recipe mergedRecipe = em.merge(existingRecipe);

                em.getTransaction().commit();
                return mergedRecipe;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error updating recipe: " + ex.getMessage());
        }
    }


    @Override
    public void delete(Integer integer) {
        try(var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            var recipe = em.find(Recipe.class, integer);
            em.remove(recipe);
            em.getTransaction().commit();
        }
    }

    @Override
    public boolean validatePrimaryKey(Integer integer) {
        try(var em = emf.createEntityManager()) {
            var person = em.find(Recipe.class, integer);
            return person != null;
        }
    }
}
