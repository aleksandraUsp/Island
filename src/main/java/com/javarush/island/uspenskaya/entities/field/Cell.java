package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.entities.organizms.Animal;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.entities.organizms.Plant;
import java.util.*;


public class Cell  {
    int row, column;
    private HashMap<Class<?>, HashSet<Organism>> herbivores;
    private HashMap<Class<?>, HashSet<Organism>> carnivores;  // <carnivore,quality>
    private HashSet<Plant> listOfPlant;
    private volatile int qualityOfPlant;
    public Cell(int row, int column) {
        herbivores = new HashMap<>();
        carnivores = new HashMap<>();
        listOfPlant = new HashSet<>();
        this.row=row;
        this.column=column;

    }

    public HashMap<Class<?>, HashSet<Organism>> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(HashMap<Class<?>, HashSet<Organism>> herbivores) {
        this.herbivores = herbivores;
    }

    public HashMap<Class<?>, HashSet<Organism>> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(HashMap<Class<?>, HashSet<Organism>> carnivores) {
        this.carnivores = carnivores;
    }

    public HashSet<Plant> getListOfPlant() {
        return listOfPlant;
    }

    public void setListOfPlant(HashSet<Plant> listOfPlant) {
        this.listOfPlant = listOfPlant;
    }

    public int getQualityOfPlant() {
        return qualityOfPlant;
    }

    public void setQualityOfPlant(int qualityOfPlant) {
        this.qualityOfPlant = qualityOfPlant;
    }

    /*
        //TODO перенести в CellService
        public void calculate() {
            for (Map.Entry<String, List<Herbivore>> entry : carnivores.entrySet()) {
                String carnivoreType = entry.getKey();
                int qualityCarnivoreThisType = entry.getValue();
                for (int i = 0; i < qualityCarnivoreThisType; i++) {
                    herbivores = carnivore.eat(herbivores); // вернули оставшихся травоядных
                }
                //TODO добавить поедание других хищников и возврат мэпы хищников
                //TODO добавить проверку на кол-во умерших или в .eat()
                qualityCarnivoreThisType = carnivore.multyply(qualityCarnivoreThisType); //вернули кол-во хищников этого типа
                entry.setValue(qualityCarnivoreThisType); //вернули увеличенное кол-во хищников

                for (int i = 0; i < qualityCarnivoreThisType; i++) {
                    carnivore.move();
                }
            }

            for (Map.Entry<Herbivore, Integer> entry : herbivores.entrySet()) {
                Herbivore herbivore = entry.getKey();
                int qualityHerbivoreThisType = entry.getValue();
                for (int i = 0; i < qualityHerbivoreThisType; i++) {
                    qualityOfPlant = herbivore.eat(qualityOfPlant);
                    //TODO добавить поедание других травоядных и возврат мэпы травояд.
                    //TODO добавить проверку на кол-во умерших или в .eat()
                    qualityHerbivoreThisType = herbivore.multyply(qualityHerbivoreThisType);
                    entry.setValue(qualityHerbivoreThisType);
                }
                for (int i = 0; i < qualityHerbivoreThisType; i++) {
                    herbivore.move();
                }
            }
        }

    */
    @Override
    public String toString() {
        return " | | ";
    }
}
