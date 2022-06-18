package com.javarush.uspenskaya.island.util;

import com.javarush.uspenskaya.island.exeption.IslandException;

public class Sleeper {
    private Sleeper() {
    }

    public static void sleep (int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IslandException(e);
        }
    }

}
