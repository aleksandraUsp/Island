package com.javarush.island.uspenskaya.repository;

import com.javarush.island.uspenskaya.entities.organizms.herbivore.Boar;
import com.javarush.island.uspenskaya.entities.organizms.herbivore.Herbivore;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.util.Randomizer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FactoryMap {

    // Map<String, HashSet<Herbivore>> herbivores
    Map<String, List<Herbivore>> herbivores;
    FactoryMap(HashSet<String> types) // List<String> values,Class nameClassValues)
    {
        HashSet<String> setOfHerbivores=new HashSet<>();
        setOfHerbivores.add("Boar");
        setOfHerbivores.add("Buffalo");
        setOfHerbivores.add("Caterpillar");
        setOfHerbivores.add("Deer");
        setOfHerbivores.add("Duck");
        setOfHerbivores.add("Goat");
        setOfHerbivores.add("Horse");
        setOfHerbivores.add("Mouse");
        setOfHerbivores.add("Rabbit");
        setOfHerbivores.add("Sheep");
        for (String type:setOfHerbivores){
            HashSet<Herbivore> herbivoresOfThisType = new HashSet<>();
            try {
                Class typeHerbivores = Class.forName(type);
            } catch (ClassNotFoundException e){
                throw new IslandException(e);
            }
        }
        AtomicInteger qualityOfAnimalsThisTypes= Randomizer.getRnd(0, Boar.class.getMaxQuality())



        Map<String, List<Herbivore>> herbivores=new HashMap<>();

    }


}
