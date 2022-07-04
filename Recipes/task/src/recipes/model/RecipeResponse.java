package recipes.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder(setterPrefix = "with")
@Getter
public class RecipeResponse {
    private String name;
    private String description;
    private String category;
    private LocalDateTime date;
    private List<String> ingredients;
    private List<String> directions;
}
