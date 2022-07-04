package recipes.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class RecipeIdResponse {
    private Long id;
}
