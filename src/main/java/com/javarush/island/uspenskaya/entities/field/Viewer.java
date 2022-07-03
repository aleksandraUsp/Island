package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Viewable;
import com.javarush.island.uspenskaya.repository.TypesOfOrganisms;
import com.javarush.island.uspenskaya.util.Configger;


import java.util.*;


public class Viewer implements Viewable {
    private final Day day;
    private final GameField gameField;
    private final int cellWidth = Configger.getConsoleCellWith();

    public Viewer(Day day, GameField gameField) {
        this.day = day;
        this.gameField = gameField;
    }

    @Override
    public void showStatistics() {
        ArrayList<Integer> result = calculateStatistics();
        System.out.println("*******" + day.getName());

        System.out.println("Количество травоядных - " + result.get(0));
        System.out.println("Количество хищников - " + result.get(1));
        System.out.println("Количество травы - " + result.get(2));
    }

    @Override
    public void showMap() {
        HashMap<Cell, HashMap<String, Integer>> mapForPrintOut = calculateForPrintOut();
        Cell[][] cells = gameField.getField();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                System.out.print(cell.print(mapForPrintOut));
            }
            System.out.println();
        }


    }

    ArrayList<Integer> calculateStatistics() {
        int qualityOfHerbivores = 0;
        int qualityOfCarnivores = 0;
        int qualityOfPlant = 0;
        Cell[][] cells = gameField.getField();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                HashMap<Class<?>, HashSet<Organism>> herbivores = cell.getHerbivores();
                HashMap<Class<?>, HashSet<Organism>> carnivores = cell.getCarnivores();
                for (Map.Entry<Class<?>, HashSet<Organism>> entry : herbivores.entrySet()) {
                    HashSet<Organism> listOfHerbivoresThisType = entry.getValue();
                    qualityOfHerbivores += listOfHerbivoresThisType.size();
                }
                for (Map.Entry<Class<?>, HashSet<Organism>> entry : carnivores.entrySet()) {
                    HashSet<Organism> listOfCarnivoresThisType = entry.getValue();
                    qualityOfCarnivores += listOfCarnivoresThisType.size();
                }
                qualityOfPlant += cell.getListOfPlant().size();
            }
        }
        ArrayList<Integer> allResult = new ArrayList<>();
        allResult.add(qualityOfHerbivores);
        allResult.add(qualityOfCarnivores);
        allResult.add(qualityOfPlant);
        return allResult;
    }

    HashMap<Cell, HashMap<String, Integer>> calculateForPrintOut() {
        HashMap<Cell, HashMap<String, Integer>> forPrint = calculateHerbivoresForPrintOut();
        forPrint = calculateCarnivoresForPrintOut(forPrint);
        forPrint = calculatePlantForPrintOut(forPrint);
        return forPrint;
    }


    HashMap<Cell, HashMap<String, Integer>> calculateHerbivoresForPrintOut() {
        HashMap<Cell, HashMap<String, Integer>> forPrint = new HashMap<>();
        Cell[][] cells = gameField.getField();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                HashMap<String, Integer> dataOneCell = new HashMap<>();
                double tempPercentMaxQuality = 0;
                String icon = null;
                int quality = 0;
                String type;
                HashMap<Class<?>, HashSet<Organism>> herbivores = cell.getHerbivores();
                for (Map.Entry<Class<?>, HashSet<Organism>> entry : herbivores.entrySet()) {
                    Class<?> typeOfHerbivores = entry.getKey();
                    HashSet<Organism> listOfHerbivoresThisType = entry.getValue();
                    int maxQualityOnCellThisType = TypesOfOrganisms.valueOf(typeOfHerbivores
                                    .getSimpleName()
                                    .toUpperCase(Locale.ROOT))
                            .getMaxQuality();
                    type = typeOfHerbivores.getSimpleName().toUpperCase(Locale.ROOT);
                    int qualityOfAnimal = listOfHerbivoresThisType.size();
                    double percentOfQualityOfAnimal = qualityOfAnimal / maxQualityOnCellThisType;
                    if (percentOfQualityOfAnimal >= tempPercentMaxQuality) {
                        tempPercentMaxQuality = percentOfQualityOfAnimal;
                        quality = qualityOfAnimal;
                        icon = TypesOfOrganisms.valueOf(type).getIcon();
                    }
                }
                dataOneCell.put(icon, quality);
                forPrint.put(cell, dataOneCell);
            }
        }
        return forPrint;
    }

    HashMap<Cell, HashMap<String, Integer>> calculateCarnivoresForPrintOut
            (HashMap<Cell, HashMap<String, Integer>> forPrint) {
        Cell[][] cells = gameField.getField();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                HashMap<String, Integer> dataOneCell = forPrint.get(cell);
                double tempMaxQuality = 0;
                String icon = null;
                String type;
                int quality = 0;
                HashMap<Class<?>, HashSet<Organism>> carnivores = cell.getCarnivores();
                for (Map.Entry<Class<?>, HashSet<Organism>> entry : carnivores.entrySet()) {
                    Class<?> typeOfCarnivores = entry.getKey();
                    HashSet<Organism> listOfCarnivoresThisType = entry.getValue();
                    type = typeOfCarnivores.getSimpleName().toUpperCase(Locale.ROOT);
                    int maxQualityOnCellThisType = TypesOfOrganisms.valueOf(typeOfCarnivores
                                    .getSimpleName()
                                    .toUpperCase(Locale.ROOT))
                            .getMaxQuality();
                    int qualityOfAnimal = listOfCarnivoresThisType.size();
                    double percentOfQualityOfAnimal = qualityOfAnimal / maxQualityOnCellThisType;
                    if (percentOfQualityOfAnimal >= tempMaxQuality) {
                        tempMaxQuality = percentOfQualityOfAnimal;
                        quality = qualityOfAnimal;
                        icon = TypesOfOrganisms.valueOf(type).getIcon();
                    }
                }
                dataOneCell.put(icon, quality);
                forPrint.put(cell, dataOneCell);
            }
        }
        return forPrint;
    }


    HashMap<Cell, HashMap<String, Integer>> calculatePlantForPrintOut
            (HashMap<Cell, HashMap<String, Integer>> forPrint) {
        String icon = TypesOfOrganisms.PLANT.getIcon();
        Cell[][] cells = gameField.getField();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                HashMap<String, Integer> dataOneCell = forPrint.get(cell);
                int qualityPlant = cell.getQualityOfPlant();
                dataOneCell.put(icon, qualityPlant);
                forPrint.put(cell, dataOneCell);
            }
        }
        return forPrint;

    }
}





