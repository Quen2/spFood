package com.cda.spfood.controller;

import com.cda.spfood.dtos.recipe.RecipeRequestDTO;
import com.cda.spfood.dtos.recipe.RecipeResponseDTO;
import com.cda.spfood.services.RecipeService;
import com.cda.spfood.services.PdfService;
import com.cda.spfood.entities.Recipe;
import com.cda.spfood.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/recipes", produces = "application/json")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final PdfService pdfService;
    private final RecipeRepository recipeRepository;

    @GetMapping
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> getRecipeById(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> getRecipePdf(@PathVariable Integer id) throws IOException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recette non trouvée avec l'ID: " + id));

        byte[] pdfContent = pdfService.generateRecipePdf(recipe);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recette_" + recipe.getName().replaceAll(" ", "_") + ".pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
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
