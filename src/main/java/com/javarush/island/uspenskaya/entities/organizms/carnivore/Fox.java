package com.javarush.island.uspenskaya.entities.organizms.carnivore;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.util.Setting;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setting(mass=8, speed= 2,maxQuality=30,saturation=2, icon="U+1F98A")
public class Fox extends Carnivore {
    private final String name;
    private final AtomicInteger number=new AtomicInteger(1);

    public Fox(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
        this.name = "Fox"+number.getAndIncrement();
    }

    @Override
    public Map<String, Integer> getRation() {
        ration.put("Wolf", 0);
        ration.put("Snake", 0);
        ration.put("Bear", 0);
        ration.put("Eagle", 0);
        ration.put("Horse", 0);
        ration.put("Deer", 0); // олень
        ration.put("Rabbit", 70);
        ration.put("Mouse", 90);
        ration.put("Goat", 0);
        ration.put("Sheep", 0);
        ration.put("Boar", 0); //кабан
        ration.put("Buffalo", 0); //буйвол
        ration.put("Duck", 60);
        ration.put("Caterpillar", 40); //гусеница
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
        return new Fox(this.getMass(), this.getSpeed(), this.getMaxQuality(), this.getSaturation(), this.getIcon());
    }

    public String toString() {
        return name + getIcon();
    }
}
