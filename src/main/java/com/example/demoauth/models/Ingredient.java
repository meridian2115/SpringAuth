package com.example.demoauth.models;

import javax.persistence.*;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredientName;  //Наименование
    private String description;     //Описание
    private String imagePath;       //Путь к изображению

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "category_ingredient",
//            joinColumns = @JoinColumn(name = "ingredient_id"),
//            inverseJoinColumns =@JoinColumn(name = "category_id"))
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private IngredientCategory category;  //Список ингредиентов в категории


    public Ingredient() {}

    public Ingredient(String ingredientName, String description, String imagePath) {
        this.ingredientName = ingredientName;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public IngredientCategory getCategories() {
        return category;
    }

    public void setCategories(IngredientCategory category) {
        this.category = category;
    }
}
