package com.cda.spfood.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipe_products")
@Getter
@Setter
public class RecipeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RP_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "RE_ID", nullable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "PR_ID", nullable = false)
    private Product product;

    @Column(name = "RP_quantity", nullable = false)
    private Integer quantity;
}

