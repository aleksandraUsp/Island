package com.javarush.island.uspenskaya.services.carnivoreservice;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.entities.organizms.carnivore.Carnivore;
import com.javarush.island.uspenskaya.util.Configger;
import com.javarush.island.uspenskaya.util.Randomizer;
import com.javarush.island.uspenskaya.util.Sleeper;

import java.util.Map;

public abstract class CarnivoreService extends AnimalService {

    private final Carnivore carnivore;
    private final Cell cell;

    public CarnivoreService(Carnivore carnivore, Cell cell) {
        this.carnivore = carnivore;
        this.cell = cell;
    }




    @Override
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
