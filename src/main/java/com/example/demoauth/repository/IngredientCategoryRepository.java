package com.example.demoauth.repository;

import com.example.demoauth.models.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Repository
public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Long> {
    Optional<IngredientCategory> findByCategoryName(String categoryName);
}
