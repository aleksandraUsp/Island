package com.javarush.island.uspenskaya.entities.organizms.carnivore;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.util.Setting;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setting(mass=15, speed= 1,maxQuality=30,saturation=3, icon="\uD83D\uDC0D")

public class Snake extends Carnivore {
    private final String name;
    private final AtomicInteger number=new AtomicInteger(1);

    public Snake(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
        this.name = "Wolf"+number.getAndIncrement();
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
        return new Snake(this.getMass(), this.getSpeed(), this.getMaxQuality(), this.getSaturation(), this.getIcon());
    }

    public String toString() {
        return name + getIcon();
    }
}

