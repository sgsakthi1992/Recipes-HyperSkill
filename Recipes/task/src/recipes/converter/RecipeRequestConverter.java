package recipes.converter;

import org.springframework.stereotype.Service;
import recipes.domain.Recipe;
import recipes.model.RecipeRequest;

import java.time.LocalDateTime;

@Service
public class RecipeRequestConverter {
    public Recipe convert(RecipeRequest recipeRequest) {
        var recipe = new Recipe();
        return convert(recipe, recipeRequest);
    }

    public Recipe convert(Recipe recipe, RecipeRequest recipeRequest) {
        recipe.setName(recipeRequest.getName());
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setDirections(recipeRequest.getDirections());
        recipe.setIngredients(recipeRequest.getIngredients());
        recipe.setCategory(recipeRequest.getCategory());
        recipe.setDate(LocalDateTime.now());
        return recipe;
    }

}
