package com.example.sampleapp;

public class AllPrivateData {

    private int id;

    private String name;

    public AllPrivateData() {
        id = 0 ;
        name = "INITName";
    }

    private int getId() {
        return id;
    }

    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AllPrivateData{" + "id=" + id + ", name='" + name + '}';
    }
}
