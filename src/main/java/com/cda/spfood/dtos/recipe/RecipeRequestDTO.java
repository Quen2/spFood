package com.cda.spfood.dtos.recipe;

public record RecipeRequestDTO(
        String name,
        Integer preparationTime,
        Integer cookingTime,
        Integer calories,
        Boolean visibility
) {
}
