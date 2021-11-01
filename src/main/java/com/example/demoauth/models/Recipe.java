package com.example.demoauth.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private Date createDate;
    private String description;
    @ManyToMany
    @JoinTable(name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns =@JoinColumn(name = "recipe_id"))
    private Set<Ingredient> ingredients;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private RecipeCategory category;

    public Recipe() {}

    public Recipe(String name, User author, Date createDate, String description) {
        this.name = name;
        this.author = author;
        this.createDate = createDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public RecipeCategory getCategory() {
        return category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }
}
