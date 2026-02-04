package com.cda.spfood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cda.spfood.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
}
