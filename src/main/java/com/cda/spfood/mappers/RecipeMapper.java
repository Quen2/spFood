package com.cda.spfood.mappers;

import com.cda.spfood.dtos.recipe.RecipeRequestDTO;
import com.cda.spfood.dtos.recipe.RecipeResponseDTO;
import com.cda.spfood.entities.Recipe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeResponseDTO toDTO(Recipe recipe);
    List<RecipeResponseDTO> toDTO(List<Recipe> recipes);

    Recipe toEntity(RecipeRequestDTO dto);
}
