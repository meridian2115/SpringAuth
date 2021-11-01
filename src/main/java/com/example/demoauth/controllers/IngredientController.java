package com.example.demoauth.controllers;

import com.example.demoauth.models.Ingredient;
import com.example.demoauth.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Fedor Danilov 01.11.2021
 */
@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IngredientController {
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Ingredient> allAccess() {
        return ingredientRepository.findAll();
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Ingredient> getIngredientById(@RequestParam(value = "id", required = false) Long id,
                                                  @RequestParam(value = "name", required = false) String name) {
        return id != null ? ingredientRepository.findById(id) : ingredientRepository.findByIngredientName(name);
    }
}
