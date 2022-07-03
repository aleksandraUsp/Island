package com.javarush.island.uspenskaya.entities.organizms;

public abstract class Animal extends Organism {


    private int speed;
    private double saturation; // насыщение


    public Animal(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, maxQuality, icon);
        this.speed = speed;
        this.saturation = saturation;
    }

    @Override
    public double getMass() {
        return super.getMass();
    }

    @Override
    public void setMass(double mass) {
        super.setMass(mass);
    }

    @Override
    public int getMaxQuality() {
        return super.getMaxQuality();
    }

    @Override
    public String getIcon() {
        return super.getIcon();
    }

    public int getSpeed() {
        return speed;
    }

    public double getSaturation() {
        return saturation;
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}


