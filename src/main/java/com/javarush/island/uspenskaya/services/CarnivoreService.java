package com.javarush.island.uspenskaya.services;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.repository.FactoryLife;
import com.javarush.island.uspenskaya.repository.TypesOfOrganisms;
import com.javarush.island.uspenskaya.util.Randomizer;

import java.util.*;


public class CarnivoreService extends AnimalService {
    Cell[][] field;

     public CarnivoreService(Cell[][] field) {
        this.field = field;
    }

    @Override
    public void initialize() {
        Cell cell;
        HashSet<Class<?>> carnivoresTypes =TypesOfOrganisms.getTypesOfCarnivores();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                cell = field[i][j];
                HashMap<Class<?>, HashSet<Organism>> carnivores=new HashMap<>();
                        for(Class<?> typeOfCarnivores:carnivoresTypes){
                            HashSet<Organism> listOfCarnivoresThisType= FactoryLife.factoryOrganism(typeOfCarnivores);
                            carnivores.put(typeOfCarnivores,listOfCarnivoresThisType);
                        }
                cell.setCarnivores(carnivores);
            }
        }
    }


    @Override
    public void reproduct(Cell[][] field) {
        Cell cell;
        int qualityOfAnimal, qualityOfAddAnimal, bandOfAnimal;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                cell = field[i][j];
                synchronized (cell) {
                    Map<Class<?>, HashSet<Organism>> carnivores = cell.getCarnivores();
                    for (Map.Entry<Class<?>, HashSet<Organism>> entry : carnivores.entrySet()) {
                        Class<?> typeOfCarnivores = entry.getKey();
                        HashSet<Organism> listOfCarnivoresThisType = entry.getValue();
                        qualityOfAnimal = listOfCarnivoresThisType.size();
                        TypesOfOrganisms type = TypesOfOrganisms.valueOf(typeOfCarnivores
                                .getSimpleName()
                                .toUpperCase(Locale.ROOT));
                        int maxQualityOfAnimal = type.getMaxQuality();
                        bandOfAnimal = maxQualityOfAnimal - qualityOfAnimal;
                        qualityOfAddAnimal = Randomizer.getRnd(0, bandOfAnimal);
                        HashSet<Organism> listOfAddCarnivoresThisType = FactoryLife.factoryOrganism(qualityOfAddAnimal, typeOfCarnivores);
//TODO разделить на чтение и запись!
                        listOfCarnivoresThisType.addAll(listOfAddCarnivoresThisType);
                        entry.setValue(listOfCarnivoresThisType);
                        /*
                        boolean isAdded =
                        if (isAdded) {
                            entry.setValue(listOfCarnivoresThisType);
                        } else System.out.println(typeOfCarnivores + " didn't reproduct");*/
                    }
                }
            }
        }
    }


    @Override
    public Map<Class<?>, HashSet<Organism>> eat(Map<Organism, Integer> organisms) {
        return null;
    }

    @Override
    public void move() {

    }
}


/*    @Override
    public void run() {
        eat(cell.herbivores);
        int timeout= Randomizer.getRnd(Configger.getMinTimeout(), Configger.getMaxTimeout());
        Sleeper.sleep(timeout);
        multiply(Integer quality);
        Sleeper.sleep(timeout);
        move();
        Sleeper.sleep(timeout);
    }
    @Override
    public Map<Organism, Integer> eat(Map<Organism, Integer> organisms) {
        return null;
    }

    @Override
    public void move() {

    }

    @Override
    public Integer multiply(Integer quality) {
        return null;
    }
}*/
