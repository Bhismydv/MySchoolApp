package com.example.myschoolapp;

public class Member {

    String name;
    String email;

    public Member() {
    }

    String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Member(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
}
