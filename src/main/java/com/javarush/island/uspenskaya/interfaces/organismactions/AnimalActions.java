package com.javarush.island.uspenskaya.interfaces.organismactions;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Eatable;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Movable;

import java.util.ArrayList;
import java.util.Map;

public interface AnimalActions extends OrganismActions, Eatable, Movable {
    @Override
    void initialize(Cell[][] field);

    @Override
    void reproduct(Cell[][] field, Organism organism);

    @Override
    Map<Class<?>, ArrayList<?>> eat(Map<Organism, Integer> organisms);

    @Override
    void move();
}
