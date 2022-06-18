package com.javarush.uspenskaya.island.entities;

public abstract class Organism {
    private int mass;
    private int maxQuality;
    private String icon;


    public Organism() {
    }

    public Organism(int mass, int maxQuality, String icon) {
        this.mass = mass;
        this.maxQuality = maxQuality;
        this.icon = icon;
    }


    public int getMass() {
        return mass;
    }

    public int getMaxQuality() {
        return maxQuality;
    }

    public String getIcon() {
        return icon;
    }
}

