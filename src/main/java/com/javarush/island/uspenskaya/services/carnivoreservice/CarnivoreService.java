package com.javarush.island.uspenskaya.services.carnivoreservice;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.entities.organizms.carnivore.Carnivore;
import com.javarush.island.uspenskaya.interfaces.organismactions.carnivoreinterface.CarnivoreActions;
import com.javarush.island.uspenskaya.repository.FactoryLife;
import com.javarush.island.uspenskaya.repository.TypesOfOrganisms;
import com.javarush.island.uspenskaya.util.Configger;
import com.javarush.island.uspenskaya.util.Randomizer;
import com.javarush.island.uspenskaya.util.Sleeper;

import java.util.ArrayList;
import java.util.Map;

public abstract class CarnivoreService implements CarnivoreActions {

    public CarnivoreService() {
    }

    @Override
    public void initialize(Cell[][] field) {
        Cell cell;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                cell = field[i][j];

                qualityOfPlant = Randomizer.getRnd(0, TypesOfOrganisms.PLANT.getMaxQuality());
                ArrayList<Plant> listOfCellPlant = FactoryLife.factoryPlant(qualityOfPlant);
                cell.setListOfPlant(listOfCellPlant);
            }
        }
    }

    @Override
    public void reproduct(Cell[][] field, Organism organism) {

    }

    @Override
    public Map<Class<?>, ArrayList<?>> eat(Map<Organism, Integer> organisms) {
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
}
