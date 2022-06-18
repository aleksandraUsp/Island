package com.javarush.uspenskaya.island.entities.herbivore;

import java.util.Map;

public class Goat extends Herbivore {
    public Goat() {
        super();
    }

    public Goat(int mass, int speed, int maxQuality, int saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
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

    @Override
    public Map<Class<?>, Integer> getRation() {
        ration.put(Horse.class, 0);
        ration.put(Deer.class, 0); // олень
        ration.put(Rabbit.class, 0);
        ration.put(Mouse.class, 0);
        ration.put(Sheep.class, 0);
        ration.put(Boar.class, 0); //кабан
        ration.put(Buffalo.class, 0); //буйвол
        ration.put(Duck.class, 0);
        ration.put(Caterpillar.class, 0); //гусеница
        ration.put(Plant.class, 100);
        return ration;
    }
}
