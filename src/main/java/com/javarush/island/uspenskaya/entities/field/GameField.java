package com.javarush.island.uspenskaya.entities.field;


public class GameField {
    private final Cell[][]field;   //100x20


    public GameField(int row, int column) {
        this.field= new Cell[row][column];
        initialize();
    }

    public Cell[][] getField() {
        return field;
    }
    public int getRows() {return field.length;}

    public int getColumns(){return field[0].length;}

    public void initialize(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Cell(i,j);
// Map<String, List<Herbivore>> herbivores, Map<String, List<Carnivore>> carnivores, int qualityOfPlant
            }

        }
    }



    public void print(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();

        }

    }
}
