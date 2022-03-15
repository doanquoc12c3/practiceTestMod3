package com.codegym.model;

public class Category {
    private int id;
    private String name;


    public Category( int id,String category) {

        this.id = id;
        this.name = category;
    }

    public Category(String category) {
        this.name = category;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
