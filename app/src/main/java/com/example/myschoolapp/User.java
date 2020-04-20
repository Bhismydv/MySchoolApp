package com.example.myschoolapp;

public class User {

String name;

    public User(String name, String email, String rollno) {
        this.name = name;
        this.email = email;
        this.rollno = rollno;
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

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public User() {
    }

    String email;
String rollno;


}

