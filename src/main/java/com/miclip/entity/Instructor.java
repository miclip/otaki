package com.miclip.entity;

public class Instructor extends Identity {

    private String name;

    public Instructor(){

    }

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
