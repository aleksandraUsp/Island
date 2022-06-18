package com.javarush.uspenskaya.island.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private Randomizer() {
    }

    public static int getRnd (int from, int to){
        return ThreadLocalRandom.current().nextInt(from,to);
    }
}
