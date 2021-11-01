package com.example.demoauth.pojo;

import com.example.demoauth.models.MenuPosition;

/**
 * @author Fedor Danilov 01.11.2021
 */
public class MenuRequest {
    private String position;
    private String name;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
