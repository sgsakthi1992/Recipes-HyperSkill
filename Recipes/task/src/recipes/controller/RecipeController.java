package recipes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import recipes.model.RecipeIdResponse;
import recipes.model.RecipeRequest;
import recipes.model.RecipeResponse;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public RecipeResponse getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping("/new")
    public RecipeIdResponse createRecipe(@RequestBody @Valid RecipeRequest recipeRequest) {
        return recipeService.createRecipe(recipeRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecipe(@PathVariable Long id, @RequestBody @Valid RecipeRequest recipeRequest) {
        recipeService.updateRecipe(id, recipeRequest);
    }

    @GetMapping("/search")
    public List<RecipeResponse> searchRecipe(@RequestParam(required = false) String category,
                                             @RequestParam(required = false) String name) {
        return recipeService.searchRecipe(category, name);
    }
}
