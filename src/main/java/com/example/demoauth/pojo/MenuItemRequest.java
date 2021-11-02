package com.example.demoauth.pojo;

import com.example.demoauth.models.Menu;
import com.example.demoauth.models.MenuItem;

/**
 * @author Fedor Danilov 01.11.2021
 */
public class MenuItemRequest {
    private String menu;
    private String name;
    private String link;
    private String parentMenuItem;
    private String description;
    private String svg;
    private int sorter;

    public int getSorter() {
        return sorter;
    }

    public void setSorter(int sorter) {
        this.sorter = sorter;
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

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getParentMenuItem() {
        return parentMenuItem;
    }

    public void setParentMenuItem(String parentMenuItem) {
        this.parentMenuItem = parentMenuItem;
    }
}
