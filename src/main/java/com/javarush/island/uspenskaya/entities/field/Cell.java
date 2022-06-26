package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.entities.organizms.carnivore.Carnivore;
import com.javarush.island.uspenskaya.entities.organizms.herbivore.Herbivore;
import java.util.*;


public class Cell  {
    private Map<Class<Herbivore>, Queue<Herbivore>> herbivores;
    private Map<Class<Carnivore>, Queue<Carnivore>> carnivores;  // <carnivore,quality>
    private ArrayList<Plant> listOfPlant;
    private volatile int qualityOfPlant;
    public Cell(int row, int column) {
        herbivores = new HashMap<Class<Herbivore>, Queue<Herbivore>>();
        carnivores = new HashMap<Class<Carnivore>, Queue<Carnivore>>();
        listOfPlant = new ArrayList<>();

    }

    public Map<Class<Herbivore>, Queue<Herbivore>> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(Map<Class<Herbivore>, Queue<Herbivore>> herbivores) {
        this.herbivores = herbivores;
    }

    public Map<Class<Carnivore>, Queue<Carnivore>> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(Map<Class<Carnivore>, Queue<Carnivore>> carnivores) {
        this.carnivores = carnivores;
    }

    public ArrayList<Plant> getListOfPlant() {
        return listOfPlant;
    }

    public void setListOfPlant(ArrayList<Plant> listOfPlant) {
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
