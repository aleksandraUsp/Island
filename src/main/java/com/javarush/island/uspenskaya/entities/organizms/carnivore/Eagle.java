package com.javarush.island.uspenskaya.entities.organizms.carnivore;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.util.Setting;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setting(mass=6, speed= 3,maxQuality=20,saturation=1, icon="U+1F98A")
public class Eagle extends Carnivore {
    private final String name;
    private final AtomicInteger number=new AtomicInteger(1);

    public Eagle(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
        this.name = "Eagle"+number.getAndIncrement();
    }

    @Override
    public Map<String, Integer> getRation() {
        ration.put("Wolf", 0);
        ration.put("Snake", 0);
        ration.put("Fox", 10);
        ration.put("Bear", 0);
        ration.put("Horse", 0);
        ration.put("Deer", 0); // олень
        ration.put("Rabbit", 90);
        ration.put("Mouse", 90);
        ration.put("Goat", 0);
        ration.put("Sheep", 0);
        ration.put("Boar", 0); //кабан
        ration.put("Buffalo", 0); //буйвол
        ration.put("Duck", 80);
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
        return new Eagle(this.getMass(), this.getSpeed(), this.getMaxQuality(), this.getSaturation(), this.getIcon());
    }

    @Override
    public String toString() {
        return name + getIcon();
    }
}
