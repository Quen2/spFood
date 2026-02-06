package com.cda.spfood.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cda.spfood.entities.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
