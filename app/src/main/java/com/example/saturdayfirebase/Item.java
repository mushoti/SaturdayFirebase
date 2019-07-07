package com.example.saturdayfirebase;

public class Item {
    private String name,email,comment,key;

    public Item(String name, String email, String comment, String key) {
        this.name = name;
        this.email = email;
        this.comment = comment;
        this.key = key;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
