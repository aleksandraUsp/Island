package com.javarush.island.uspenskaya.entities.organizms.carnivore;

import com.javarush.island.uspenskaya.entities.organizms.Animal;
import com.javarush.island.uspenskaya.entities.organizms.Organism;

import java.util.HashMap;
import java.util.Map;

public abstract class Carnivore extends Animal /*хищник*/ {

    public Map<String, Integer> ration = new HashMap<>();

    public Carnivore(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);

    }

    public Map<String, Integer> getRation() {
        ration.put("Snake", 0);
        ration.put("Fox", 0);
        ration.put("Bear", 0);
        ration.put("Eagle", 0);
        ration.put("Horse", 10);
        ration.put("Deer", 15); // олень
        ration.put("Rabbit", 60);
        ration.put("Mouse", 80);
        ration.put("Goat", 60);
        ration.put("Sheep", 70);
        ration.put("Boar", 15); //кабан
        ration.put("Buffalo", 10); //буйвол
        ration.put("Duck", 40);
        ration.put("Caterpillar", 0); //гусеница
        return ration;
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
    public int getSpeed() {
        return super.getSpeed();
    }

    @Override
    public double getSaturation() {
        return super.getSaturation();
    }

    @Override
    public String getIcon() {
        return super.getIcon();
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}






