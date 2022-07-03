package com.javarush.island.uspenskaya.thread;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.field.Game;
import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.PlantService;

import java.util.concurrent.Callable;



public class PlantServiceTask implements Callable<Integer> {
    GameField gameField;
    PlantService plantService;


    public PlantServiceTask(GameField gameField) {
        this.gameField=gameField;
        this.plantService = gameField.getPlantService();
    }

    @Override
    public Integer call() {
        int isGood = 1;
        try {
            plantService.reproduct(gameField.getField());
        } catch (Exception e) {
            throw new IslandException("PlantService isn't good" + e);
        }
        return isGood;
    }
}
