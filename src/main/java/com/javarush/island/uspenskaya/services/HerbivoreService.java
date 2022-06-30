package com.javarush.island.uspenskaya.services;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.repository.FactoryLife;
import com.javarush.island.uspenskaya.repository.TypesOfOrganisms;
import com.javarush.island.uspenskaya.util.Randomizer;

import java.util.*;
import java.util.concurrent.Callable;

public class HerbivoreService extends AnimalService {
    HashSet<Class<?>> herbivoresTypes = TypesOfOrganisms.getTypesOfHerbivores();
    Cell[][] field;

    public HerbivoreService(Cell[][] field) {
        this.field = field;
    }

    @Override
    public void initialize(Cell[][] field) {
        Cell cell;
       for (int i = field.length-1; i >=0 ; i--) {
            for (int j = field[i].length-1; j >=0; j--) {
                cell = field[i][j];
                HashMap<Class<?>, HashSet<Organism>> herbivores=new HashMap<>();
                for(Class<?> typeOfHerbivores:herbivoresTypes){
                    HashSet<Organism> listOfCarnivoresThisType= FactoryLife.factoryOrganism(typeOfHerbivores);
                    herbivores.put(typeOfHerbivores,listOfCarnivoresThisType);
                }
                cell.setCarnivores(herbivores);
            }
        }
    }



    @Override
    public void reproduct(Cell[][] field) {
        Cell cell;
        int qualityOfAnimal, qualityOfAddAnimal, bandOfAnimal;
        for (int i = field.length-1; i >=0 ; i--) {
            for (int j = field[i].length-1; j >=0; j--) {
                cell = field[i][j];

                    Map<Class<?>, HashSet<Organism>> herbivores = cell.getHerbivores();
                synchronized (cell) {
                    for (Map.Entry<Class<?>, HashSet<Organism>> entry : herbivores.entrySet()) {
                        Class<?> typeOfHerbivores = entry.getKey();
                        HashSet<Organism> listOfHerbivoresThisType = entry.getValue();
                        qualityOfAnimal = listOfHerbivoresThisType.size();
                        TypesOfOrganisms type = TypesOfOrganisms.valueOf(typeOfHerbivores
                                .getSimpleName()
                                .toUpperCase(Locale.ROOT));
                        int maxQualityOfAnimal = type.getMaxQuality();
                        bandOfAnimal = maxQualityOfAnimal - qualityOfAnimal;
                        qualityOfAddAnimal = Randomizer.getRnd(0, bandOfAnimal);
                        HashSet<Organism> listOfAddHerbivoresThisType = FactoryLife.factoryOrganism(qualityOfAddAnimal, typeOfHerbivores);
//TODO разделить на чтение и запись!
                        boolean isAdded = listOfHerbivoresThisType.addAll(listOfAddHerbivoresThisType);
                        if (isAdded) {
                            entry.setValue(listOfHerbivoresThisType);
                        } else System.out.println(typeOfHerbivores + "didn't reproduct");
                    }
                }
            }
        }
    }

    @Override
    public Map<Class<?>, HashSet<Organism>> eat(Map<Organism, Integer> organisms) {
        return super.eat(organisms);
    }

    @Override
    public void move() {
        super.move();
    }
}
