package com.javarush.island.uspenskaya;

import com.javarush.island.uspenskaya.entities.field.Game;


public class Runner {
    public static void main(String[] args) {
        System.out.println("Да будет остров!");
        Game game = new Game();
        game.getGameField().print();
        game.playGame();

        //HashSet<Class<?>>organisms =TypesOfOrganisms.getTypesOfOrganisms();
        //Map<Class<?>, Organism> mapOfPrototypes= FactoryEtalonOrganisms.createPrototypesMap(organisms);

    }
}
