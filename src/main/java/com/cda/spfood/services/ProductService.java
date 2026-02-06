package com.cda.spfood.services;

import com.cda.spfood.dtos.product.ProductRequestDTO;
import com.cda.spfood.dtos.product.ProductResponseDTO;
import com.cda.spfood.entities.Product;
import com.cda.spfood.mappers.ProductMapper;
import com.cda.spfood.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponseDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTO(products);
    }

    public ProductResponseDTO findById(Integer id) {
        Product product = null;
        if (productRepository.findById(id).isPresent()) {
            product = productRepository.findById(id).get();
        }
        return productMapper.toDTO(product);
    }

    public void update(Integer id, ProductRequestDTO productRequestDTO) {
        productRepository.save(productMapper.toEntity(productRequestDTO));
    }

    public void save(ProductRequestDTO productRequestDTO) {
        productRepository.save(productMapper.toEntity(productRequestDTO));
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
