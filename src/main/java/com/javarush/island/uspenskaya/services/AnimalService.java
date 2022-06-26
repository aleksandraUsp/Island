package com.javarush.island.uspenskaya.services;


import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Eatable;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Movable;

public abstract class AnimalService extends OrganismService implements Eatable, Movable  {

    public void initialize(){
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public Organism multiply() {
        return null;
    }
}
