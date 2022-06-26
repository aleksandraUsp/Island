package com.javarush.island.uspenskaya.repository;

import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.entities.organizms.carnivore.*;
import com.javarush.island.uspenskaya.entities.organizms.herbivore.*;

import java.util.HashSet;

public enum TypesOfOrganisms {
    BEAR(Bear.class,5),
    EAGLE(Eagle.class, 20),
    FOX(Fox.class, 30),
    SNAKE(Snake.class, 30),
    WOLF(Wolf.class, 30),
    BOAR(Boar.class, 5),
    BUFFALO(Buffalo.class, 10),
    CATERPILLAR(Caterpillar.class, 1000),
    DEER(Deer.class, 20),
    DUCK(Duck.class, 200),
    GOAT(Goat.class, 140),
    HORSE(Horse.class, 20),
    MOUSE(Mouse.class, 500),
    RABBIT(Rabbit.class, 150),
    SHEEP(Sheep.class, 140),
    PLANT(Plant.class, 200);

    private final Class<?> type;
    private int maxQuality;

    TypesOfOrganisms(Class<?> type,int maxQuality){
        this.type=type;
        this.maxQuality=maxQuality;
    }

    public Class<?> getType() {
        return type;
    }

    public int getMaxQuality() {
        return maxQuality;
    }

    public void setMaxQuality(int maxQuality) {
        this.maxQuality = maxQuality;
    }

    public static HashSet<Class<?>> getTypesOfOrganisms() {
        HashSet<Class<?>> setOfOrganisms = new HashSet<>();
        for (TypesOfOrganisms organism : TypesOfOrganisms.values()) {
            setOfOrganisms.add(organism.getType());
        }
        return setOfOrganisms;
    }

    @Override
    public String toString() {
        return "TypesOfOrganisms{" +
                "type=" + type +
                '}';
    }
}
