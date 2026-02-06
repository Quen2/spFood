package com.cda.spfood.dtos.product;

import com.cda.spfood.entities.enums.products.ProductType;

public record ProductRequestDTO(
        String name,
        ProductType productType,
        Integer calories
) {
}
