package recipes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class RecipeRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String category;
    @NotNull
    @Size(min = 1)
    private List<String> ingredients;
    @NotNull
    @Size(min = 1)
    private List<String> directions;
}
