package com.javarush.island.uspenskaya;


import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.entities.organizms.Organism;
import com.javarush.island.uspenskaya.repository.FactoryEtalonOrganisms;
import com.javarush.island.uspenskaya.repository.TypesOfOrganisms;
import com.javarush.island.uspenskaya.util.Configger;

import java.util.HashSet;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Да будет остров!");
        GameField gameField = new GameField(Configger.getRow(), Configger.getColumn());
        gameField.initialize();
        HashSet<Class<?>>organisms =TypesOfOrganisms.getTypesOfOrganisms();
        Map<Class<?>, Organism> mapOfPrototypes= FactoryEtalonOrganisms.createPrototypesMap(organisms);
        System.out.println("Да будет трава на острове!");




        gameField.print();
    }
}
