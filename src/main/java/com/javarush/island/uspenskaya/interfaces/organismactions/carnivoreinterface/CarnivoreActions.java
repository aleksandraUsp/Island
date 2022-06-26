package com.javarush.island.uspenskaya.interfaces.organismactions.carnivoreinterface;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.organismactions.AnimalActions;


import java.util.ArrayList;
import java.util.Map;

public interface CarnivoreActions extends AnimalActions {
    @Override
    void initialize(Cell[][] field);

    @Override
    void reproduct(Cell[][] field, Organism organism);

    @Override
    Map<Class<?>, ArrayList<?>> eat(Map<Organism, Integer> organisms);

    @Override
    void move();
}
