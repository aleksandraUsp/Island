package com.javarush.island.uspenskaya.interfaces.organismactions.carnivoreinterface;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Eatable;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Movable;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Reproducible;


import java.util.Map;

public interface CarnivoreAction extends Eatable, Reproducible, Movable, Cloneable {
    @Override
    Map<Organism, Integer> eat();

    @Override
    void move();

    @Override
    Integer multiply(Integer quality);
}
