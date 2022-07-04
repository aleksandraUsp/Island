package ru.javarush.island.uspenskaya.entities.field;

import ru.javarush.island.uspenskaya.entities.organizms.Animal;
import ru.javarush.island.uspenskaya.entities.organizms.Plant;
import java.util.*;



public class Cell  {
    int row, column;
    private HashMap<Class<?>, HashSet<Animal>> herbivores;
    private HashMap<Class<?>, HashSet<Animal>> carnivores;  // <carnivore,quality>
    private HashSet<Plant> listOfPlant;


    public Cell(int row, int column) {
        herbivores = new HashMap<>();
        carnivores = new HashMap<>();
        listOfPlant = new HashSet<>();
        this.row=row;
        this.column=column;
    }

    public Cell getMonitor(int row, int column){
        return this;
    }
    public HashMap<Class<?>, HashSet<Animal>> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(HashMap<Class<?>, HashSet<Animal>> herbivores) {
        this.herbivores = herbivores;
    }

    public HashMap<Class<?>, HashSet<Animal>> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(HashMap<Class<?>, HashSet<Animal>> carnivores) {
        this.carnivores = carnivores;
    }

    public HashSet<Plant> getListOfPlant() {
        return listOfPlant;
    }

    public void setListOfPlant(HashSet<Plant> listOfPlant) {
        this.listOfPlant = listOfPlant;
    }

    public int getQualityOfPlant() {
        return listOfPlant.size();
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

    public String print(HashMap<Cell, HashMap<String, Integer>> mapForPrintOut) {
        HashMap<String, Integer> leaders=mapForPrintOut.get(this);
        ArrayList<String> out = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : leaders.entrySet()) {
            String icon = entry.getKey();
            Integer quality=entry.getValue();
            out.add(icon+"="+quality);
        }
        return "|"+out.get(0)+";"+out.get(1)+";"+out.get(2)+"|";
    }
}
