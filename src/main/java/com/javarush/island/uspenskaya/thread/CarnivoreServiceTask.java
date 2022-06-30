package com.javarush.island.uspenskaya.thread;

import com.javarush.island.uspenskaya.entities.field.Game;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.CarnivoreService;


import java.util.concurrent.Callable;

public class CarnivoreServiceTask implements Callable<Integer> {
    Game game;
    CarnivoreService carnivoreService;


    public CarnivoreServiceTask(Game game, CarnivoreService carnivoreService) {
        this.game=game;
        this.carnivoreService = carnivoreService;
    }

    @Override
    public Integer call() {
        int isGood = 1;
        try {
            carnivoreService.reproduct(game.getGameField().getField());
        } catch (Exception e) {
            throw new IslandException("CarnivoreService isn't good" + e);
        }
        return isGood;
    }

}
