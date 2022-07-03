package com.javarush.island.uspenskaya.entities.organizms.carnivore;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.util.Setting;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setting(mass=500, speed= 2,maxQuality=5,saturation=80, icon="\uD83D\uDC3B")
public class Bear extends Carnivore {
    private final AtomicInteger number=new AtomicInteger(1);
    private final String name;

    public Bear(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
        this.name = "Bear"+number.getAndIncrement();
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

    public String getName() {
        return name;
    }

    public AtomicInteger getNumber() {
        return number;
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
       return new Bear(this.getMass(), this.getSpeed(), this.getMaxQuality(), this.getSaturation(), this.getIcon());
    }

    public String toString() {
        return name + getIcon();
    }
}
