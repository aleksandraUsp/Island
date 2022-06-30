package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.exeption.IslandException;
import com.javarush.island.uspenskaya.services.HerbivoreService;
import com.javarush.island.uspenskaya.services.CarnivoreService;
import com.javarush.island.uspenskaya.services.PlantService;
import com.javarush.island.uspenskaya.thread.CarnivoreServiceTask;
import com.javarush.island.uspenskaya.thread.HerbivoreServiceTask;
import com.javarush.island.uspenskaya.thread.PlantServiceTask;
import com.javarush.island.uspenskaya.util.Configger;

import java.util.concurrent.*;

public class Game {
    private Day day;
    private GameField gameField;
    private final HerbivoreService herbivoreService;
    private final CarnivoreService carnivoreService;
    private final PlantService plantService;
    private Viewer viewer;
    private volatile boolean isCancel=false;

    public Game() {
        this.day=new Day();
        this.gameField = new GameField(Configger.getRow(), Configger.getColumn());
        gameField.initialize();
        this.herbivoreService = new HerbivoreService(gameField.getField());
        this.carnivoreService = new CarnivoreService(gameField.getField());
        this.plantService = new PlantService(gameField.getField());
        this.viewer = new Viewer(day,gameField.getField());

        initializeGame();
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public HerbivoreService getHerbivoreService() {
        return herbivoreService;
    }

    public CarnivoreService getCarnivoreService() {
        return carnivoreService;
    }

    public PlantService getPlantService() {
        return plantService;
    }

    public void initializeGame(){
        this.plantService.initialize(gameField.getField());
        this.herbivoreService.initialize(gameField.getField());
        this.carnivoreService.initialize(gameField.getField());
    }

    public void playGame() {
        FutureTask<Integer> futurePlantService=new FutureTask<>(new PlantServiceTask(this, getPlantService()));
        FutureTask<Integer> futureCarnivoreService=new FutureTask<>(new CarnivoreServiceTask(this, getCarnivoreService()));
        FutureTask<Integer> futureHerbivoreService=new FutureTask<>(new HerbivoreServiceTask(this, getHerbivoreService()));
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        /*Queue<FutureTask<Integer>> queueTasks = new ConcurrentLinkedQueue<>();
        queueTasks.add(futurePlantService);
        queueTasks.add(futureCarnivoreService);
        queueTasks.add(futureHerbivoreService);
        for (FutureTask<Integer> task:queueTasks) {*/
            //TODO - isCancel
            while(!isCancel) {
                try {
                    Future resultPlant = executorService.scheduleAtFixedRate
                            (futurePlantService, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
                    Future resultCarnivore = executorService.scheduleAtFixedRate
                            (futureCarnivoreService, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
                    Future resultHerbivore = executorService.scheduleAtFixedRate
                            (futureHerbivoreService, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
                    if ((Integer)resultPlant.get()==1 && (Integer)resultCarnivore.get()==1 && (Integer)resultHerbivore.get()==1)
                        viewer.print(day);
                } catch(InterruptedException|ExecutionException e){
                    throw new IslandException(e);
                }
            }
            executorService.shutdown();

        }

        //executorService.awaitTermination(900,TimeUnit.MILLISECONDS);








}

