package com.javarush.island.uspenskaya.thread;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.field.Game;
import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.PlantService;

import java.util.concurrent.Callable;



public class PlantServiceTask implements Callable<Integer> {
    Game game;
    PlantService plantService;


    public PlantServiceTask(Game game, PlantService plantService) {
        this.game=game;
        this.plantService = plantService;
    }

    @Override
    public Integer call() {
        int isGood = 1;
        try {
            plantService.reproduct(game.getGameField().getField());
        } catch (Exception e) {
            throw new IslandException("PlantService isn't good" + e);
        }
        return isGood;
    }
}
