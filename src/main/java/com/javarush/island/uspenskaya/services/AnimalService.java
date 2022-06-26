package com.javarush.island.uspenskaya.services;


import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.organismactions.AnimalActions;


import java.util.ArrayList;
import java.util.Map;

public class AnimalService implements AnimalActions {
    public AnimalService() {

    }

    @Override
    public void initialize(Cell[][] field) {

    }

    @Override
    public void reproduct(Cell[][] field, Organism organism) {

    }

    @Override
    public Map<Class<?>, ArrayList<?>> eat(Map<Organism, Integer> organisms) {
        return null;
    }

    @Override
    public void move() {

    }
}

