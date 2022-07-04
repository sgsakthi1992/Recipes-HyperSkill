package recipes.converter;

import org.springframework.stereotype.Service;
import recipes.domain.Recipe;
import recipes.model.RecipeIdResponse;
import recipes.model.RecipeResponse;

@Service
public class RecipeResponseConverter {
    public RecipeIdResponse convert(Long id){
        return RecipeIdResponse.builder()
                .withId(id)
                .build();
    }

    public RecipeResponse convert(Recipe recipe) {
        return RecipeResponse.builder()
                .withName(recipe.getName())
                .withDescription(recipe.getDescription())
                .withDirections(recipe.getDirections())
                .withIngredients(recipe.getIngredients())
                .withCategory(recipe.getCategory())
                .withDate(recipe.getDate())
                .build();
    }
}
