package com.example.myschoolapp;

public class Study {

    String subject;

    public Study(String subject, String teacherid, String desc) {
        this.subject = subject;
        this.teacherid = teacherid;
        this.desc = desc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Study() {
    }

    String teacherid;
    String desc;
}
