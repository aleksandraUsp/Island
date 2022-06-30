package com.javarush.island.uspenskaya.interfaces.simpleinterface;

import com.javarush.island.uspenskaya.entities.organizms.Animal;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import java.util.HashSet;
import java.util.Map;

public interface Eatable {
    Map<Class<?>, HashSet<Organism>> eat(Map<Organism,Integer> organisms);
}
