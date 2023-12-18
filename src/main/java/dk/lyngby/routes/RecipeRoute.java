package dk.lyngby.routes;

import dk.lyngby.controller.impl.RecipeController;
import dk.lyngby.security.RouteRoles;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class RecipeRoute {

    private final RecipeController recipeController = new RecipeController();

    protected EndpointGroup getRoutes() {

        return () -> {
            path("/recipes", () -> {
                post("/", recipeController::create, RouteRoles.ADMIN, RouteRoles.MANAGER);
                get("/", recipeController::readAll, RouteRoles.ANYONE);
                get("/{id}", recipeController::read, RouteRoles.USER, RouteRoles.ADMIN, RouteRoles.MANAGER);
                put("/{id}", recipeController::update, RouteRoles.ADMIN, RouteRoles.MANAGER);
                delete("/{id}", recipeController::delete, RouteRoles.ADMIN, RouteRoles.MANAGER);
            });
        };
    }
}