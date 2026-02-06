package com.cda.spfood.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID")
    private Integer id;

    @Column(name = "US_lastname", nullable = false)
    private String lastname;

    @Column(name = "US_firstname", nullable = false)
    private String firstname;

    @Column(name = "US_role", nullable = false)
    private String role;

    @Column(name = "US_password", nullable = false)
    private String password;

    @Column(name = "US_phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "US_email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Recipe> recipes;

    @ManyToMany
    @JoinTable(
            name = "user_favorite_recipes",
            joinColumns = @JoinColumn(name = "US_ID"),
            inverseJoinColumns = @JoinColumn(name = "RE_ID")
    )
    private List<Recipe> favoriteRecipes;
}
