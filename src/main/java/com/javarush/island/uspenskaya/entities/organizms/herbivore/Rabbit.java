package com.javarush.island.uspenskaya.entities.organizms.herbivore;

import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.util.Setting;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setting(mass=2, speed= 2,maxQuality=150,saturation=0.45, icon="\uD83D\uDC07")
public class Rabbit  extends Herbivore {
    private final String name;
    private final AtomicInteger number=new AtomicInteger(1);

    public Rabbit(double mass, int speed, int maxQuality, double saturation, String icon) {
        super(mass, speed, maxQuality, saturation, icon);
        this.name = "Rabbit"+number.getAndIncrement();
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
    public Map<Class<?>, Integer> getRation() {
        ration.put(Horse.class, 0);
        ration.put(Deer.class, 0); // олень
        ration.put(Mouse.class, 0);
        ration.put(Goat.class, 0);
        ration.put(Sheep.class, 0);
        ration.put(Boar.class, 0); //кабан
        ration.put(Buffalo.class, 0); //буйвол
        ration.put(Duck.class, 0);
        ration.put(Caterpillar.class, 0); //гусеница
        ration.put(Plant.class, 100);
        return ration;
    }

    @Override
    public String toString() {
        return name + getIcon();
    }
}