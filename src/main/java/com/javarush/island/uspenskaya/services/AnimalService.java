package com.javarush.island.uspenskaya.services;


import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.organismactions.AnimalActions;
import java.util.HashSet;
import java.util.Map;

public class AnimalService implements AnimalActions {
    public AnimalService() {

    }

    @Override
    public void initialize() {

    }

    @Override
    public void reproduct(Cell[][] field) {

    }

    @Override
    public Map<Class<?>, HashSet<Organism>> eat(Map<Organism, Integer> organisms) {
        return null;
    }

    @Override
    public void move() {

    }
}

