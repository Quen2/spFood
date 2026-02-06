package com.cda.spfood.dtos.product;

import com.cda.spfood.entities.enums.products.ProductType;

public record ProductResponseDTO(
        Integer id,
        String name,
        ProductType productType,
        Integer calories
) {
}
