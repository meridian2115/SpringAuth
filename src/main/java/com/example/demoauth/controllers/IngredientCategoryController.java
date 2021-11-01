package com.example.demoauth.controllers;

import com.example.demoauth.models.IngredientCategory;
import com.example.demoauth.repository.IngredientCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fedor Danilov 01.11.2021
 */
@RestController
@RequestMapping("/ingredients/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IngredientCategoryController {
    @Autowired
    private IngredientCategoryRepository categoryRepository;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<IngredientCategory> allAccess() {
        return categoryRepository.findAll();
    }
}
