package com.javarush.island.uspenskaya.repository;

import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.util.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class FactoryLife<TODO> {

    public FactoryLife() {
    }

    public static ArrayList<Plant> factoryPlant(int qualityOfPlant) {
        Plant prototypeOfPlant = (Plant) getPrototypeThisType(TypesOfOrganisms.PLANT.getType());
        ArrayList<Plant> listOfPlant = new ArrayList<>(qualityOfPlant);
        for (Plant plant : listOfPlant) {
            plant = prototypeOfPlant.clone();
            plant.setMass(Randomizer.getRndDouble(0, TypesOfOrganisms.PLANT.getMaxQuality()));
            listOfPlant.add(plant);
        }
        return listOfPlant;
    }

    static Organism getPrototypeThisType(Class<?> clazz){
        Map<Class<?>, Organism> mapOfEtalonOrganisms = FactoryEtalonOrganisms.createPrototypesMap
                (TypesOfOrganisms.getTypesOfOrganisms());
        return mapOfEtalonOrganisms.get(clazz);
    }
}

    /*for (Map.Entry<String, List<Herbivore>> entry : carnivores.entrySet()) {
        String carnivoreType = entry.getKey();
        int qualityCarnivoreThisType = entry.getValue();
        for (int i = 0; i < qualityCarnivoreThisType; i++) {
            herbivores = carnivore.eat(herbivores); // вернули оставшихся травоядных
        }*/

