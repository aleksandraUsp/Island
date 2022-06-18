package com.javarush.uspenskaya.island.entities;

public class GameField {
    Cell[][]field = new Cell[100][20];

    public void initialize(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Cell();

            }

        }
    }
    public void print(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] = new Cell());
            }
            System.out.println();

        }

    }
}
