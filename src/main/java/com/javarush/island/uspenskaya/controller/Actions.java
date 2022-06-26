package com.javarush.island.uspenskaya.controller;

public enum Actions {
    INITLIFE (new InitLife()),
}

/*
public enum Actions {


    ENCODE (new Encoder()),
    DECODE (new Decoder()),
    BRUTEFORCE (new BruteForce());

    //ANALYSIS (new Analysis ());


    private final Action action;

    Actions(Action action) {
        this.action = action;
    }
    public static Action find(String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase()); //ищет по action команду
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException();
        }
    }
}
*/
