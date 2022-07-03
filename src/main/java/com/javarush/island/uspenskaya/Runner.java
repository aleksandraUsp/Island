package com.javarush.island.uspenskaya;

import com.javarush.island.uspenskaya.entities.field.Day;
import com.javarush.island.uspenskaya.entities.field.Game;
import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.util.Configger;
import com.javarush.island.uspenskaya.util.Sleeper;


public class Runner {
    public static void main(String[] args) {
        System.out.println("Да будет остров!");
        Day day = new Day();
        GameField gameField = new GameField(Configger.getRow(), Configger.getColumn());
        Game game = new Game(gameField, day);
        game.playGame();

    }
}
