package com.cda.spfood.dtos.recipe;

public record RecipeDTO(
        String name,
        Integer preparationTime,
        Integer cookingTime,
        Integer calories,
        Boolean visibility
) {
}
