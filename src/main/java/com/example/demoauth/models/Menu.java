package com.example.demoauth.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private MenuPosition position;
    private String name;

    //private Set<MenuItem> menuItems = new HashSet<>();

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
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

    public MenuPosition getPosition() {
        return position;
    }

    public void setPosition(MenuPosition position) {
        this.position = position;
    }
}
