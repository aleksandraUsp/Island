package com.javarush.uspenskaya.island.entities.carnivore;

import com.javarush.uspenskaya.island.entities.*;
import com.javarush.uspenskaya.island.entities.carnivore.*;

import java.util.Map;

public class Snake extends Carnivore {
    public Snake() {
        super();
    }

    public Snake(int mass, int speed, int maxQuality, int saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
    }

    @Override
    public Map<String, Integer> getRation() {
        ration.put("Wolf", 0);
        ration.put("Fox", 15);
        ration.put("Bear", 0);
        ration.put("Eagle", 0);
        ration.put("Horse", 0);
        ration.put("Deer", 0); // олень
        ration.put("Rabbit", 20);
        ration.put("Mouse", 40);
        ration.put("Goat", 0);
        ration.put("Sheep", 0);
        ration.put("Boar", 0); //кабан
        ration.put("Buffalo", 0); //буйвол
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
