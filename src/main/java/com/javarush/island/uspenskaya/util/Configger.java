package com.javarush.island.uspenskaya.util;

public class Configger {

    private static int  minTimeout = 200;
    private static int  maxTimeout = 500;
    private static double  valueOfMassForDeath = 0.5; // коэф.снижения массы тела, при кот. животные умирают
    private static int row=10;
    private static int column=10;



    public static int getMinTimeout() {
        return minTimeout;
    }

    public static void setMinTimeout(int minTimeout) {
        Configger.minTimeout = minTimeout;
    }

    public static int getMaxTimeout() {
        return maxTimeout;
    }

    public static void setMaxTimeout(int maxTimeout) {
        Configger.maxTimeout = maxTimeout;
    }

    public static double getValueOfMassForDeath() {
        return valueOfMassForDeath;
    }

    public static void setValueOfMassForDeath(double valueOfMassForDeath) {
        Configger.valueOfMassForDeath = valueOfMassForDeath;
    }

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        Configger.row = row;
    }

    public static int getColumn() {
        return column;
    }

    public static void setColumn(int column) {
        Configger.column = column;
    }
}
