package com.cda.spfood.mappers;

import com.cda.spfood.dtos.product.ProductRequestDTO;
import com.cda.spfood.dtos.product.ProductResponseDTO;
import com.cda.spfood.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface ProductMapper {
    ProductResponseDTO toDTO(Product product);
    List<ProductResponseDTO> toDTO(List<Product> products);

    Product toEntity(ProductRequestDTO dto);
}
