package com.example.jdbc;

public class Country {
    private String code;
    private String name;
    private String SurfaceArea;
    private String Population;

    public Country(String code, String name, String surfaceArea, String population) {
        this.code = code;
        this.name = name;
        SurfaceArea = surfaceArea;
        Population = population;
    }

    public Country() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurfaceArea(String surfaceArea) {
        SurfaceArea = surfaceArea;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSurfaceArea() {
        return SurfaceArea;
    }

    public String getPopulation() {
        return Population;
    }
}
