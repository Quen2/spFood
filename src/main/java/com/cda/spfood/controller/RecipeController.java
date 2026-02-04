package com.cda.spfood.controller;

import com.cda.spfood.dtos.recipe.RecipeRequestDTO;
import com.cda.spfood.dtos.recipe.RecipeResponseDTO;
import com.cda.spfood.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/recipes", produces = "application/json")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> getRecipeById(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> saveRecipe(@RequestBody RecipeRequestDTO recipe) {
        recipeService.save(recipe);
        return ResponseEntity.ok("{\"message\": \"Recette ajoutée\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRecipe(@PathVariable Integer id, @RequestBody RecipeRequestDTO recipe) {
        recipeService.update(id, recipe);
        return ResponseEntity.ok("{\"message\": \"Recette mise à jour\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer id) {
        recipeService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Recette supprimée\"}");
    }
}
