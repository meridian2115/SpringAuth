package com.example.demoauth.pojo;

/**
 * @author Fedor Danilov 29.10.2021
 */
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
