package com.francis.example.crudtext;

public class Details {

    private int legend;
    private String name;
    private String location;

    public Details(int legend, String name, String location) {
        this.legend = legend;
        this.name = name;
        this.location = location;
    }

    public Details(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public int getLegend() {
        return legend;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
