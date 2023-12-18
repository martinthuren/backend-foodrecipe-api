package dk.lyngby.controller.impl;

import dk.lyngby.config.HibernateConfig;
import dk.lyngby.controller.IController;
import dk.lyngby.dao.impl.RecipeDao;
import dk.lyngby.dto.RecipeDto;
import dk.lyngby.model.Recipe;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class RecipeController implements IController<Recipe, Integer> {

    private final RecipeDao dao;

    public RecipeController() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        this.dao = RecipeDao.getInstance(emf);
    }

    @Override
    public void read(Context ctx)  {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).check(this::validatePrimaryKey, "Not a valid id").get();
        // entity
        Recipe recipe = dao.read(id);
        // dto
        RecipeDto recipeDto = new RecipeDto(recipe);
        // response
        ctx.res().setStatus(200);
        ctx.json(recipeDto, RecipeDto.class);
    }

    @Override
    public void readAll(Context ctx) {
        // entity
        List<Recipe> recipes = dao.readAll();
        // dto
        List<RecipeDto> recipeDtos = RecipeDto.toRecipeDTOList(recipes);
        // response
        ctx.res().setStatus(200);
        ctx.json(recipeDtos, RecipeDto.class);
    }

    @Override
    public void create(Context ctx) {
        // request
        //Hotel jsonRequest = validateEntity(ctx);
        Recipe jsonRequest = ctx.bodyAsClass(Recipe.class);
        // entity
        Recipe recipe = dao.create(jsonRequest);
        // dto
        RecipeDto recipeDto = new RecipeDto(recipe);
        // response
        ctx.res().setStatus(201);
        ctx.json(recipeDto, RecipeDto.class);
    }

    @Override
    public void update(Context ctx) {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).check(this::validatePrimaryKey, "Not a valid id").get();
        // entity
        Recipe update = dao.update(id, validateEntity(ctx));
        // dto
        RecipeDto recipeDto = new RecipeDto(update);
        // response
        ctx.res().setStatus(200);
        ctx.json(recipeDto, Recipe.class);
    }

    @Override
    public void delete(Context ctx) {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).check(this::validatePrimaryKey, "Not a valid id").get();
        // entity
        dao.delete(id);
        // response
        ctx.res().setStatus(204);
    }

    @Override
    public boolean validatePrimaryKey(Integer integer) {
        return dao.validatePrimaryKey(integer);
    }

    @Override
    public Recipe validateEntity(Context ctx) {
        return ctx.bodyValidator(Recipe.class)
                .check( h -> h.getRecipeName() != null && !h.getRecipeName().isEmpty(), "Recipe name must be set")
                .check( h -> h.getRecipeType() != null, "Recipe type must be set")
                .get();
    }

}
