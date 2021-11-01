package com.example.demoauth.models;

import javax.persistence.*;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private String name;
    private String link;
    @ManyToOne
    @JoinColumn(name = "par_menu_item_id")
    private MenuItem parentMenuItem;
    private String description;
    private String svg;

    public MenuItem() {}

    public MenuItem(Menu menu, String name, String link, MenuItem parentMenuItem, String description, String svg) {
        this.menu = menu;
        this.name = name;
        this.link = link;
        this.parentMenuItem = parentMenuItem;
        this.description = description;
        this.svg = svg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MenuItem getParentMenuItem() {
        return parentMenuItem;
    }

    public void setParentMenuItem(MenuItem parentMenuItem) {
        this.parentMenuItem = parentMenuItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }
}
