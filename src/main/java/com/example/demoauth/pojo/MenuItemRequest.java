package com.example.demoauth.pojo;

import com.example.demoauth.models.Menu;
import com.example.demoauth.models.MenuItem;

/**
 * @author Fedor Danilov 01.11.2021
 */
public class MenuItemRequest {
    private Menu menu;
    private String name;
    private String link;
    private MenuItem parentMenuItem;
    private String description;
    private String svg;

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
