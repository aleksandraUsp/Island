package ru.javarush.island.uspenskaya.services;

import ru.javarush.island.uspenskaya.entities.field.Cell;
import ru.javarush.island.uspenskaya.entities.organizms.Animal;
import ru.javarush.island.uspenskaya.entities.organizms.carnivore.Carnivore;
import ru.javarush.island.uspenskaya.entities.organizms.herbivore.Herbivore;
import ru.javarush.island.uspenskaya.repository.FactoryLife;
import ru.javarush.island.uspenskaya.repository.TypesOfOrganisms;
import ru.javarush.island.uspenskaya.util.Configger;
import ru.javarush.island.uspenskaya.util.Randomizer;

import java.util.*;



public class CarnivoreService extends AnimalService {
    Cell[][] field;

     public CarnivoreService(Cell[][] field) {
        this.field = field;
    }

    @Override
    public void initialize() {
        Cell cell;
        HashSet<Class<?>> carnivoresTypes = TypesOfOrganisms.getTypesOfCarnivores();

        for (Cell[] cells : field) {
            for (int j = 0; j < cells.length; j++) {
                cell = cells[j];
                HashMap<Class<?>, HashSet<Animal>> carnivores = new HashMap<>();
                for (Class<?> typeOfCarnivores : carnivoresTypes) {
                    HashSet<Animal> listOfCarnivoresThisType = FactoryLife.factoryOrganism(typeOfCarnivores);
                    carnivores.put(typeOfCarnivores, listOfCarnivoresThisType);
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
                synchronized (cell.getMonitor()) {
                    Map<Class<?>, HashSet<Animal>> carnivores = cell.getCarnivores();
                    for (Map.Entry<Class<?>, HashSet<Animal>> entry : carnivores.entrySet()) {
                        Class<?> typeOfCarnivores = entry.getKey();
                        HashSet<Animal> listOfCarnivoresThisType = entry.getValue();
                        qualityOfAnimal = listOfCarnivoresThisType.size();
                        TypesOfOrganisms type = TypesOfOrganisms.valueOf(typeOfCarnivores
                                .getSimpleName()
                                .toUpperCase(Locale.ROOT));
                        int maxQualityOfAnimal = type.getMaxQuality();
                        bandOfAnimal = maxQualityOfAnimal - qualityOfAnimal;
                        qualityOfAddAnimal = Randomizer.getRnd(0, bandOfAnimal);
                        HashSet<Animal> listOfAddCarnivoresThisType = FactoryLife.factoryOrganism(qualityOfAddAnimal, typeOfCarnivores);
                        listOfCarnivoresThisType.addAll(listOfAddCarnivoresThisType);
                        entry.setValue(listOfCarnivoresThisType);

                    }
                }
            }
        }
    }


    @Override
    public void eat() {
        Cell cell;
        for (int i = field.length-1; i >= 0; i--) {
            for (int j = field[i].length - 1; j >= 0; j--) {
                cell = field[i][j];

                synchronized (cell.getMonitor()) {
                    HashMap<Class<?>, HashSet<Animal>> carnivores = cell.getCarnivores();
                    for (Map.Entry<Class<?>, HashSet<Animal>> entry : carnivores.entrySet()) {
                        Class<?> classOfCarnivores = entry.getKey();
                        HashSet<Animal> listOfCarnivoresThisType = entry.getValue();
                        eatThisTypeCarnivores(cell, classOfCarnivores,
                                listOfCarnivoresThisType);
                    }
                }
            }
        }
    }


    @Override
    public void move() {

    }

    private void eatThisTypeCarnivores(Cell cell, Class<?> classOfCarnivores,
                                       HashSet<Animal> listOfCarnivoresThisType) {
        HashMap<Class<?>, HashSet<Animal>> herbivores=cell.getHerbivores();
        HashMap<Class<?>, HashSet<Animal>> carnivores=cell.getCarnivores();

        for (Animal animal : listOfCarnivoresThisType) {
            TypesOfOrganisms type = TypesOfOrganisms.valueOf(classOfCarnivores
                    .getSimpleName()
                    .toUpperCase(Locale.ROOT));
            double massOfAnimal = animal.getMass();
            Map<Class<?>, Integer> rationThisTypeAnimal = animal.getRation();
            Comparator<Map.Entry<Class<?>, Integer>> rationComparator =
                    (o1, o2) -> o1.getValue() - o2.getValue();
            TreeSet<Map.Entry<Class<?>, Integer>> sortedRationSet= new TreeSet<>(rationComparator);
            sortedRationSet.addAll(rationThisTypeAnimal.entrySet());
            for (Map.Entry<Class<?>, Integer> entryProbability:sortedRationSet) {
                Class<?> clazzOfEat = entryProbability.getKey();
               //Integer probability = entryProbability.getValue();
                double tempSaturation = 0;


                if (clazzOfEat.getSuperclass().isInstance(Herbivore.class)) {
                    HashSet<Animal> setOfAnimalToEat = herbivores.get(clazzOfEat);
                    if (setOfAnimalToEat.size() > 0) {
                        for (Animal animalForEating : setOfAnimalToEat) {
                            double massOfAnimalForEating = animalForEating.getMass();
                            if (massOfAnimalForEating < animal.getSaturation() &&
                                    massOfAnimalForEating + massOfAnimal < type.getMaxMass()) {
                                massOfAnimal = massOfAnimal + massOfAnimalForEating;
                                tempSaturation = tempSaturation + massOfAnimalForEating;
                                animalForEating.setMass(0.0);
                            }
                        }
                    }
                }

                if (clazzOfEat.getSuperclass().isInstance(Carnivore.class)) {
                    HashSet<Animal> setOfAnimalToEat = carnivores.get(clazzOfEat);
                    if (setOfAnimalToEat.size() > 0) {
                        for (Animal animalForEating : setOfAnimalToEat) {
                            double massOfAnimalForEating = animalForEating.getMass();
                            if (massOfAnimalForEating < animal.getSaturation() &&
                                    massOfAnimalForEating + massOfAnimal < type.getMaxMass()) {
                                massOfAnimal = massOfAnimal + massOfAnimalForEating;
                                tempSaturation = tempSaturation + massOfAnimalForEating;
                                animalForEating.setMass(0.0);
                            }
                        }
                    }
                }
                if (tempSaturation == animal.getSaturation() || massOfAnimal == type.getMaxMass())   {
                    cell.setHerbivores(herbivores);
                break;}
                            }
                            animal.setMass(massOfAnimal);
                }
        cell.setCarnivores(carnivores);
        HerbivoreService.dieHerbivores(cell);
        dieCarnivores(cell);
        }


    public static void dieCarnivores(Cell cell) {
        synchronized (cell.getMonitor()) {
            HashMap<Class<?>, HashSet<Animal>> carnivores = cell.getCarnivores();
            for (Map.Entry<Class<?>, HashSet<Animal>> entryCarnivoresMayBeDie : carnivores.entrySet()) {
                HashSet<Animal> setOfCarnivoresMayBeDie = entryCarnivoresMayBeDie.getValue();
                Class<?> classOfCarnivores = entryCarnivoresMayBeDie.getKey();
                TypesOfOrganisms type = TypesOfOrganisms.valueOf(classOfCarnivores
                        .getSimpleName()
                        .toUpperCase(Locale.ROOT));
                Iterator<Animal> it = setOfCarnivoresMayBeDie.iterator();
                while (it.hasNext()) {
                    Animal animalMayBeDie = it.next();
                    if (animalMayBeDie.getMass() <= type.getMaxMass() * Configger.getValueOfMassForDeath())
                        it.remove();
                }
            }
            cell.setCarnivores(carnivores);
        }
    }
}


