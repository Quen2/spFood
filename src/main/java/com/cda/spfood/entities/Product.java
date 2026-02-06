package com.cda.spfood.entities;

import com.cda.spfood.entities.enums.products.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PR_ID")
    private Integer id;

    @Column(name = "PR_lib", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "PR_type", nullable = false)
    private ProductType type;

    @Column(name = "PR_cal", nullable = false)
    private Integer calories;
}
