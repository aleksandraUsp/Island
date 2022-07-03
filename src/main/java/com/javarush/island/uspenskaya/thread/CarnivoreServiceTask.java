package com.javarush.island.uspenskaya.thread;

import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.CarnivoreService;


import java.util.concurrent.Callable;

public class CarnivoreServiceTask implements Callable<Integer> {
    GameField gameField;
    CarnivoreService carnivoreService;


    public CarnivoreServiceTask(GameField gameField) {
        this.gameField=gameField;
        this.carnivoreService = gameField.getCarnivoreService();
    }

    @Override
    public Integer call() {
        int isGood = 1;
        try {
            carnivoreService.reproduct(gameField.getField());
        } catch (Exception e) {
            throw new IslandException("CarnivoreService isn't good" + e);
        }
        return isGood;
    }

}
