package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.entities.field.Cell;

public class GameField {
    private int row;
    private int column;
    private Cell[][]field;   //100x20


    public GameField(int row, int column) {
        this.row = row;
        this.column = column;
        field= new Cell[row][column];
        initialize();
    }

    public void initialize(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Cell(i,j);
// Map<String, List<Herbivore>> herbivores, Map<String, List<Carnivore>> carnivores, int qualityOfPlant
            }

        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Cell[][] getField() {
        return field;
    }

    public void setField(Cell[][] field) {
        this.field = field;
    }

    public void print(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(this.field);
            }
            System.out.println();

        }

    }
}
