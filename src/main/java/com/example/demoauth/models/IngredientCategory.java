package com.example.demoauth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class IngredientCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;    //Наименование категории
    private String imagePath;       //Путь к изображению
    private String description;     //Описание категории

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns =@JoinColumn(name = "category_id"))
    private Set<Ingredient> ingredients= new HashSet<>();  //Список ингредиентов в категории


    public IngredientCategory() {}

    public IngredientCategory(String categoryName, String imagePath, String description) {
        this.categoryName = categoryName;
        this.imagePath = imagePath;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
