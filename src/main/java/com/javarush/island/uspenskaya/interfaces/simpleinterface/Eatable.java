package com.javarush.island.uspenskaya.interfaces.simpleinterface;

import com.javarush.island.uspenskaya.entities.organizms.Organism;

import java.util.Map;

public interface Eatable {
    Map<Organism,Integer> eat(Map<Organism,Integer> organisms);
}
