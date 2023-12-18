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
    public Recipe update(Integer integer, Recipe recipe) {
        try(var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var h = em.find(Recipe.class, integer);
            h.setRecipeName(recipe.getRecipeName());
            h.setRecipeType(recipe.getRecipeType());
            Recipe merge = em.merge(h);
            em.getTransaction().commit();
            return merge;
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
