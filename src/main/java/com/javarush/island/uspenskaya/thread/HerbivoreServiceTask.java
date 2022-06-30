package com.javarush.island.uspenskaya.thread;

import com.javarush.island.uspenskaya.entities.field.Game;
import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.HerbivoreService;

import java.util.concurrent.Callable;

public class HerbivoreServiceTask implements Callable<Integer> {
    Game game;
    HerbivoreService herbivoreService;


    public HerbivoreServiceTask(Game game, HerbivoreService herbivoreService) {
        this.game=game;
        this.herbivoreService = herbivoreService;
    }

    @Override
    public Integer call() {
        int isGood = 1;
        try {
            herbivoreService.reproduct(game.getGameField().getField());
        } catch (Exception e) {
            throw new IslandException("HerbivoreService isn't good" + e);
        }
        return isGood;
    }

}

