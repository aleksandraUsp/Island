package com.javarush.island.uspenskaya.interfaces.simpleinterface;

import com.javarush.island.uspenskaya.entities.organizms.Organism;

import java.util.ArrayList;
import java.util.Map;

public interface Eatable {
    Map<Class<?>, ArrayList<?>> eat(Map<Organism,Integer> organisms);
}
