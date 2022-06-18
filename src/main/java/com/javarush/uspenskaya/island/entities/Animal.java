package com.javarush.uspenskaya.island.entities;

public abstract class Animal extends Organism {
    private int mass;
    private int speed;
    private int maxQuality;
    private int saturation; // насыщение
    private String icon;


    public Animal() {
    }

    public Animal(int mass, int speed, int maxQuality, int saturation, String icon) {
        this.mass = mass;
        this.speed = speed;
        this.maxQuality = maxQuality;
        this.saturation=saturation;
        this.icon=icon;
    }


    public int getMass() {
        return mass;
    }

    public int getMaxQuality() {
        return maxQuality;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSaturation() {
        return saturation;
    }

    public String getIcon() {
        return icon;
    }
}

