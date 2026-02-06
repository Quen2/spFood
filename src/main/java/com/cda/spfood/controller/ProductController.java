package com.cda.spfood.controller;

import com.cda.spfood.dtos.product.ProductRequestDTO;
import com.cda.spfood.dtos.product.ProductResponseDTO;
import com.cda.spfood.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody ProductRequestDTO product) {
        productService.save(product);
        return ResponseEntity.ok("{\"message\": \"Produit ajouté\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDTO product) {
        productService.update(id, product);
        return ResponseEntity.ok("{\"message\": \"Produit mis à jour\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Produit supprimé\"}");
    }
}
