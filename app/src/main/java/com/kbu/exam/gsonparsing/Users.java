package com.kbu.exam.gsonparsing;

public class Users {
    String imageUrl;
    String id;
    String name;
    String email;

    public Users(String imageUrl, String id, String name, String email) {
        this.imageUrl = imageUrl;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Users() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
