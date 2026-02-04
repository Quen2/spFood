package com.cda.spfood.dtos.recipe;

public record RecipeResponseDTO(
        Integer id,
        String name,
        Integer preparationTime,
        Integer cookingTime,
        Integer calories,
        Boolean visibility
) {
}
