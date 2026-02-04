package com.cda.spfood.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RE_ID")
    private Integer id;

    @Column(name = "RE_name", nullable = false)
    private String name;

    @Column(name = "RE_preparation_time", nullable = false)
    private Integer preparationTime;

    @Column(name = "RE_cooking_time", nullable = false)
    private Integer cookingTime;

    @Column(name = "RE_cal", nullable = false)
    private Integer calories;

    @Column(name = "RE_visibility", nullable = false)
    private Boolean visibility;
}
