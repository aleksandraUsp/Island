package com.javarush.uspenskaya.island.entities;

import com.javarush.uspenskaya.island.entities.carnivore.Carnivore;
import com.javarush.uspenskaya.island.entities.herbivore.Herbivore;
import com.javarush.uspenskaya.island.util.Randomizer;
import java.util.*;

public class Cell {
    Map<Herbivore,Integer> herbivores = new HashMap<>();
    Map<Carnivore,Integer> carnivores = new HashMap<>(); // <carnivore,quality>
    int qualityOfPlant = Randomizer.getRnd(10,500);

    # TODO //перенести в CellService
    public void calculate(){
        for (Map.Entry<Carnivore,Integer> entry:carnivores.entrySet()) {
            Carnivore carnivore = entry.getKey();
            Integer probability
        }



        }

    }


    @Override
    public String toString() {
        return " | | ";
    }
}
