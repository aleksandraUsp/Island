package com.javarush.uspenskaya.island.entities.carnivore;

import com.javarush.uspenskaya.island.entities.Animal;

import java.util.HashMap;
import java.util.Map;

public class Carnivore extends Animal /*хищник*/ {
    private int mass;
    private int maxQuality;
    private int speed;
    private int saturation; // насыщение
    private String icon;
    public Map<String, Integer> ration = new HashMap<>();


    public Carnivore() {
        super();
    }

    public Carnivore(int mass, int speed, int maxQuality, int saturation, String icon) {
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
    public int getMass() {
        return super.getMass();
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
    public int getSaturation() {
        return super.getSaturation();
    }

    @Override
    public String getIcon() {
        return icon;
    }
}


