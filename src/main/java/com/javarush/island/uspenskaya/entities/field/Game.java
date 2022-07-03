package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.exeption.IslandException;

import com.javarush.island.uspenskaya.thread.CarnivoreServiceTask;
import com.javarush.island.uspenskaya.thread.HerbivoreServiceTask;
import com.javarush.island.uspenskaya.thread.PlantServiceTask;
import com.javarush.island.uspenskaya.util.Configger;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Game {
    private final GameField gameField;
    private final Day day;
    private boolean isCanceled=false;


    //private volatile boolean isCancel = false;

    public Game(GameField gameField, Day day) {
        this.day = day;
        this.gameField = gameField;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public void playGame() {
        Viewer viewer = new Viewer(day, gameField);
        viewer.showStatistics();
        viewer.showMap();
        FutureTask<Integer> futurePlantService = new FutureTask<>(new PlantServiceTask(gameField));
        FutureTask<Integer> futureCarnivoreService = new FutureTask<>(new CarnivoreServiceTask(gameField));
        FutureTask<Integer> futureHerbivoreService = new FutureTask<>(new HerbivoreServiceTask(gameField));


        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);
        List<FutureTask<Integer>> listTasks = new ArrayList<>();
        listTasks.add(futurePlantService);
        listTasks.add(futureCarnivoreService);
        listTasks.add(futureHerbivoreService);

        mainPool.scheduleAtFixedRate(() -> {
                ExecutorService servicePool = Executors.newFixedThreadPool(4);
                listTasks.forEach(servicePool::submit);

                try {
                    if (futurePlantService.get() == 1 && futureCarnivoreService.get() == 1 && futureHerbivoreService.get() == 1) {
                        viewer.showStatistics();
                        viewer.showMap();
                    }
                /*
                FutureTask<String> futureViewer=new FutureTask<>(new Viewer(day, gameField));
                Future resultViewer = executorService.schedule(futureViewer,4,TimeUnit.SECONDS);

                servicePool.shutdown();
            try {


                if (servicePool.awaitTermination(Configger.getPeriod()/2, TimeUnit.MILLISECONDS)) {
                    viewer.showStatistics();
                    viewer.showMap();
                }*/
                } catch (InterruptedException | ExecutionException e) {
                    throw new IslandException(e);
                }
            }, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);


    }
}
/*
        for (FutureTask<Integer> task:queueTasks) {
            //TODO - isCancel
            while(!isCancel) {
                try {
                    Future resultPlant = executorService.scheduleAtFixedRate
                            (futurePlantService, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
                    Future resultCarnivore = executorService.scheduleAtFixedRate
                            (futureCarnivoreService, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
                    Future resultHerbivore = executorService.scheduleAtFixedRate
                            (futureHerbivoreService, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
                    if ((Integer)resultPlant.get()==1 && (Integer)resultCarnivore.get()==1 && (Integer)resultHerbivore.get()==1) {

                    FutureTask<String> futureViewer=new FutureTask<>(new Viewer(day, gameField));
                    Future resultViewer = executorService.schedule(futureViewer,4,TimeUnit.SECONDS);

                    executorService.shutdown();
                    if (executorService.awaitTermination(Configger.getPeriod(), TimeUnit.SECONDS)) {
                    Future resultViewer = executorService.schedule(futureViewer, Configger.getPeriod(), TimeUnit.SECONDS);}

                } catch(InterruptedException|ExecutionException e){
                    throw new IslandException(e);
                }
            }
            executorService.shutdown();

        }

        //executorService.awaitTermination(900,TimeUnit.MILLISECONDS);
        */











