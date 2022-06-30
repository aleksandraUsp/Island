package com.javarush.island.uspenskaya.repository;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.entities.organizms.carnivore.*;
import com.javarush.island.uspenskaya.entities.organizms.herbivore.*;

import java.util.HashSet;

public enum TypesOfOrganisms {
    BEAR(Bear.class,5,500),
    EAGLE(Eagle.class, 20, 6),
    FOX(Fox.class, 30, 8),
    SNAKE(Snake.class, 30, 15),
    WOLF(Wolf.class, 30, 50),
    BOAR(Boar.class, 5, 400),
    BUFFALO(Buffalo.class, 10, 700),
    CATERPILLAR(Caterpillar.class, 1000, 0.01),
    DEER(Deer.class, 20, 300),
    DUCK(Duck.class, 200, 1),
    GOAT(Goat.class, 140, 60),
    HORSE(Horse.class, 20, 400),
    MOUSE(Mouse.class, 500, 0.05),
    RABBIT(Rabbit.class, 150, 2),
    SHEEP(Sheep.class, 140, 70),
    PLANT(Plant.class, 200, 1);

    private final Class<?> type;
    private int maxQuality;
    private double maxMass;


    TypesOfOrganisms(Class<?> type,int maxQuality,double maxMass){
        this.type=type;
        this.maxQuality=maxQuality;
        this.maxMass = maxMass;
    }

    public Class<?> getType() {
        return type;
    }

    public int getMaxQuality() {
        return maxQuality;
    }

    public double getMaxMass() {
        return maxMass;
    }

    public static HashSet<Class<?>> getTypesOfOrganisms() {
        HashSet<Class<?>> setOfOrganisms = new HashSet<>();
        for (TypesOfOrganisms organism : TypesOfOrganisms.values()) {
            setOfOrganisms.add(organism.getType());
        }
        return setOfOrganisms;
    }

    public static HashSet<Class<?>> getTypesOfCarnivores() {
        HashSet<Class<?>> setOfCarnivores = new HashSet<>();
        for (TypesOfOrganisms organism : TypesOfOrganisms.values()) {
            if (organism.getType().getSuperclass()== Carnivore.class) {
                setOfCarnivores.add(organism.getType());
            }
        }
        return setOfCarnivores;
    }

    public static HashSet<Class<?>> getTypesOfHerbivores() {
        HashSet<Class<?>> setOfHerbivores = new HashSet<>();
        for (TypesOfOrganisms organism : TypesOfOrganisms.values()) {
            if (organism.getType().getSuperclass()== Herbivore.class) {
                setOfHerbivores.add(organism.getType());
            }
        }
        return setOfHerbivores;
    }

    @Override
    public String toString() {
        return "TypesOfOrganisms{" +
                "type=" + type +
                '}';
    }
}
