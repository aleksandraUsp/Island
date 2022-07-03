package com.javarush.island.uspenskaya.interfaces.organismactions;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Eatable;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Movable;


import java.util.HashSet;
import java.util.Map;

public interface AnimalActions extends OrganismActions, Eatable, Movable {
    @Override
    void initialize();

    @Override
    void reproduct(Cell[][] field);

    @Override
    Map<Class<?>, HashSet<Organism>> eat(Map<Organism, Integer> organisms);

    @Override
    void move();
}
