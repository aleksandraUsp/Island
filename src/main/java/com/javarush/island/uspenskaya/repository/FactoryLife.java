package com.javarush.island.uspenskaya.repository;

import com.javarush.island.uspenskaya.entities.organizms.Animal;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.entities.organizms.Plant;
import com.javarush.island.uspenskaya.util.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

public class FactoryLife {

    public FactoryLife() {
    }
    public static HashSet<Organism> factoryOrganism(Class<?> clazz) {
        TypesOfOrganisms type= TypesOfOrganisms.valueOf(clazz.getSimpleName().toUpperCase(Locale.ROOT));
        double maxMass = type.getMaxMass();
        int maxQualityOfOrganism = type.getMaxQuality();
        Organism prototypeOfOrganism = getPrototypeThisType(clazz);
        HashSet<Organism> listOfOrganisms = new HashSet<>(maxQualityOfOrganism);
        for (int i = 0; i < maxQualityOfOrganism; i++) {
            Organism organism = prototypeOfOrganism.clone();
            organism.setMass(Randomizer.getRndDouble(0, maxMass));
            listOfOrganisms.add(organism);
        }
        return listOfOrganisms;
    }

    public static HashSet<Organism> factoryOrganism(int qualityOfOrganism, Class<?> clazz) {
        TypesOfOrganisms type= TypesOfOrganisms.valueOf(clazz.getSimpleName().toUpperCase(Locale.ROOT));
        double maxMass = type.getMaxMass();
        Organism prototypeOfOrganism = getPrototypeThisType(clazz);
        HashSet<Organism> listOfOrganism = new HashSet<>(qualityOfOrganism);
        for (int i = 0; i < qualityOfOrganism; i++) {
            Organism organism = prototypeOfOrganism.clone();
            organism.setMass(Randomizer.getRndDouble(0, maxMass));
            listOfOrganism.add(organism);
        }
        return listOfOrganism;
    }

    public static HashSet<Plant> factoryPlant(int qualityOfPlant) {
        Plant prototypeOfPlant = (Plant) getPrototypeThisType(TypesOfOrganisms.PLANT.getType());
        HashSet<Plant> listOfPlant = new HashSet<>(qualityOfPlant);
        for (int i = 0; i < qualityOfPlant; i++) {
            Plant plant = prototypeOfPlant.clone();
            plant.setMass(Randomizer.getRndDouble(0, TypesOfOrganisms.PLANT.getMaxMass()));
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

