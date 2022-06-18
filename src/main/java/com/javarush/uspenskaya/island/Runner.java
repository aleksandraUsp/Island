package com.javarush.uspenskaya.island;


import com.javarush.uspenskaya.island.entities.GameField;

public class Runner {
    public static void main(String[] args) {
        GameField gameField = new GameField();
        gameField.initialize();
        gameField.print();


    }
}
