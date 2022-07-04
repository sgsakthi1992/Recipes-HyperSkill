package recipes.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import recipes.converter.RecipeRequestConverter;
import recipes.converter.RecipeResponseConverter;
import recipes.domain.Recipe;
import recipes.exception.ActionForbiddenException;
import recipes.exception.InvalidParametersException;
import recipes.exception.RecipeNotFoundException;
import recipes.model.RecipeIdResponse;
import recipes.model.RecipeRequest;
import recipes.model.RecipeResponse;
import recipes.repository.RecipeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeRequestConverter recipeRequestConverter;
    private final RecipeResponseConverter recipeResponseConverter;

    public RecipeService(RecipeRepository recipeRepository, RecipeRequestConverter recipeRequestConverter, RecipeResponseConverter recipeResponseConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeRequestConverter = recipeRequestConverter;
        this.recipeResponseConverter = recipeResponseConverter;
    }

    public RecipeResponse getRecipe(Long id) {
        var recipe = recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id + " not found"));
        return recipeResponseConverter.convert(recipe);
    }

    public RecipeIdResponse createRecipe(RecipeRequest recipeRequest) {
        var recipe = recipeRequestConverter.convert(recipeRequest);
        var author = getUserDetails().getUser();
        recipe.setAuthor(author);
        recipe = recipeRepository.save(recipe);
        return recipeResponseConverter.convert(recipe.getId());
    }

    public void deleteRecipe(Long id) {
        var recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id + " not found"));
        if (isAuthorAuthenticated(recipe.getAuthor().getEmail())) {
            recipeRepository.delete(recipe);
        } else {
            throw new ActionForbiddenException();
        }
    }

    public void updateRecipe(Long id, RecipeRequest recipeRequest) {
        var recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id + " not found"));
        if (isAuthorAuthenticated(recipe.getAuthor().getEmail())) {
            recipe = recipeRequestConverter.convert(recipe, recipeRequest);
            recipeRepository.save(recipe);
        } else {
            throw new ActionForbiddenException();
        }
    }

    public List<RecipeResponse> searchRecipe(String category, String name) {
        List<Recipe> recipes;
        if (category == null && name == null) {
            throw new InvalidParametersException();
        } else if (category != null) {
            recipes = recipeRepository.findByCategoryIgnoreCase(category);
        } else {
            recipes = recipeRepository.findByNameContainsIgnoreCase(name);
        }
        return recipes.stream()
                .map(recipeResponseConverter::convert)
                .sorted(Comparator.comparing(RecipeResponse::getDate).reversed())
                .collect(Collectors.toList());
    }

    private Boolean isAuthorAuthenticated(String email) {
        return getUserDetails().getUsername().equals(email);
    }

    private UserDetailsImpl getUserDetails() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) auth.getPrincipal();
    }
}
