package dk.lyngby.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter

@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", nullable = false, unique = true)
    private Integer id;

    @Setter
    @Column(name = "recipe_name", nullable = false, unique = true)
    private String recipeName;

    @Setter
    @Column(name = "recipe_img", nullable = false)
    private String recipeImg;

    @Setter
    @Column(name = "recipe_description", nullable = false)
    private String recipeDescription;

    @Setter
    @Column(name = "recipe_type", nullable = false)
    private RecipeType recipeType;

    @Setter
    @Column(name = "recipe_preptime", nullable = false)
    private Integer recipePreptime;

    @Setter
    @Column(name = "recipe_ingredients", nullable = false)
    private String recipeIngredients;

    @Setter
    @Column(name = "recipe_directions", nullable = false)
    private String recipeDirections;

    public Recipe(String recipeName, String recipeImg, RecipeType recipeType, String recipeDescription, Integer recipePreptime, String recipeIngredients, String recipeDirections) {
        this.recipeName = recipeName;
        this.recipeImg = recipeImg;
        this.recipeType = recipeType;
        this.recipeDescription = recipeDescription;
        this.recipePreptime = recipePreptime;
        this.recipeIngredients = recipeIngredients;
        this.recipeDirections = recipeDirections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName);
    }

    public enum RecipeType {
        BREAKFAST, LUNCH, DINNER, DESSERT, SNACK, DRINK;
    }
}
