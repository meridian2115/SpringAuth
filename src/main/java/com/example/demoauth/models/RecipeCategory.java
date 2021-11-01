package com.example.demoauth.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class RecipeCategory {
    @Id
    private Long id;
    private String categoryName;    //Наименование категории
    private String imagePath;       //Путь к изображению
    private String description;     //Описание категории
}
