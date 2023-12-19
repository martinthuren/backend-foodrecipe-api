package dk.lyngby.dto;

import dk.lyngby.model.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class RecipeDto {

    private Integer id;
    private String recipeName;
    private String recipeImg;
    private String recipeDescription;
    private Recipe.RecipeType recipeType;
    private Integer recipePreptime;
    private String recipeIngredients;
    private String recipeDirections;

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.recipeName = recipe.getRecipeName();
        this.recipeImg = recipe.getRecipeImg();
        this.recipeType = recipe.getRecipeType();
        this.recipeDescription = recipe.getRecipeDescription();
        this.recipePreptime = recipe.getRecipePreptime();
        this.recipeIngredients = recipe.getRecipeIngredients();
        this.recipeDirections = recipe.getRecipeDirections();
    }

    public RecipeDto(String recipeName, String recipeDescription, Recipe.RecipeType recipeType)
    {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeType = recipeType;
    }


    public static List<RecipeDto> toRecipeDTOList(List<Recipe> recipes) {
        return recipes.stream().map(RecipeDto::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof RecipeDto recipeDto)) return false;

        return getId().equals(recipeDto.getId());
    }

    @Override
    public int hashCode()
    {
        return getId().hashCode();
    }

}
