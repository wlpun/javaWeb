package com.example.jdbc;

public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private String population;

    public City(String name, String countryCode, String district, String population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public City(int id, String name, String district, String population) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.population = population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public City() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public String getPopulation() {
        return population;
    }
}
