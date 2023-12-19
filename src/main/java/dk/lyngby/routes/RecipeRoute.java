package dk.lyngby.routes;

import dk.lyngby.controller.impl.RecipeController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class RecipeRoute {

    private final RecipeController recipeController = new RecipeController();

    protected EndpointGroup getRoutes() {

        return () -> {
            path("/recipes", () -> {
                post("/", recipeController::create);
                get("/", recipeController::readAll);
                get("/{id}", recipeController::read);
                put("/{id}", recipeController::update);
                delete("/{id}", recipeController::delete);
            });
        };
    }
}