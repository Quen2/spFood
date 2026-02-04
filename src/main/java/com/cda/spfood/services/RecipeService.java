package com.cda.spfood.services;

import com.cda.spfood.dtos.recipe.RecipeRequestDTO;
import com.cda.spfood.dtos.recipe.RecipeResponseDTO;
import com.cda.spfood.entities.Recipe;
import com.cda.spfood.mappers.RecipeMapper;
import com.cda.spfood.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public List<RecipeResponseDTO> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipeMapper.toDTO(recipes);
    }

    public RecipeResponseDTO findById(Integer id) {
        Recipe recipe = null;
        if (recipeRepository.findById(id).isPresent()) {
            recipe = recipeRepository.findById(id).get();
        }
        return recipeMapper.toDTO(recipe);
    }

    public void update(Integer id, RecipeRequestDTO recipeRequestDTO) {
        recipeRepository.save(recipeMapper.toEntity(recipeRequestDTO));
    }

    public void save(RecipeRequestDTO recipeRequestDTO) {
        recipeRepository.save(recipeMapper.toEntity(recipeRequestDTO));
    }

    public void delete(Integer id) {
        recipeRepository.deleteById(id);
    }
}
