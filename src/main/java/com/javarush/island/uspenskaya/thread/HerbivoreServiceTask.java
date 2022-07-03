package com.javarush.island.uspenskaya.thread;

import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.HerbivoreService;
import java.util.concurrent.Callable;

public class HerbivoreServiceTask implements Callable<Integer> {
    GameField gameField;
    HerbivoreService herbivoreService;


    public HerbivoreServiceTask(GameField gameField) {
        this.gameField=gameField;
        this.herbivoreService = gameField.getHerbivoreService();
    }

    @Override
    public Integer call() {
        int isGood = 1;
        try {
            herbivoreService.reproduct(gameField.getField());
        } catch (Exception e) {
            throw new IslandException("HerbivoreService isn't good" + e);
        }
        return isGood;
    }

}

