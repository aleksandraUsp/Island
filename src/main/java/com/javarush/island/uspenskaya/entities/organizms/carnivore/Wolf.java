package com.javarush.island.uspenskaya.entities.organizms.carnivore;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.util.Setting;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setting(mass=50, speed= 3,maxQuality=30,saturation=8, icon="🐺")
public class Wolf extends Carnivore {
    private final AtomicInteger number=new AtomicInteger(1);
    private final String name;

    public Wolf(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
        this.name = "Wolf"+number.getAndIncrement();
    }

    @Override
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
        return new Wolf(this.getMass(), this.getSpeed(), this.getMaxQuality(), this.getSaturation(), this.getIcon());
    }


    public String toString() {
        return name + getIcon();
    }
}
