package com.example.sessionpractise;

public class Student {
    private String id;
    private int energy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Student(String id, int energy) {
        this.id = id;
        this.energy = energy;
    }
}
