package com.example.sampleapp;

public class AllPrivateData {

    private int id;

    private String name;

    public AllPrivateData() {
        id = 0 ;
        name = "INITName";
    }

    @Override
    public String toString() {
        return "AllPrivateData{" + "id=" + id + ", name='" + name + '}';
    }
}
