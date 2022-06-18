package com.javarush.uspenskaya.island.entities.carnivore;

import com.javarush.uspenskaya.island.entities.carnivore.Carnivore;

import java.util.Map;

public class Bear extends Carnivore {
    public Bear() {
        super();
    }

    public Bear(int mass, int speed, int maxQuality, int saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
    }

    @Override
    public Map<String, Integer> getRation() {
        ration.put("Wolf", 0);
        ration.put("Snake", 80);
        ration.put("Fox", 0);
        ration.put("Eagle", 0);
        ration.put("Horse", 40);
        ration.put("Deer", 80); // олень
        ration.put("Rabbit", 80);
        ration.put("Mouse", 90);
        ration.put("Goat", 70);
        ration.put("Sheep", 70);
        ration.put("Boar", 50); //кабан
        ration.put("Buffalo", 20); //буйвол
        ration.put("Duck", 10);
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
        return super.getIcon();
    }
}
