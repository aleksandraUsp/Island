package ru.javarush.island.uspenskaya.services;

import ru.javarush.island.uspenskaya.entities.field.Day;
import ru.javarush.island.uspenskaya.entities.field.GameField;
import ru.javarush.island.uspenskaya.entities.field.Viewer;
import ru.javarush.island.uspenskaya.exeption.IslandException;
import ru.javarush.island.uspenskaya.thread.CarnivoreServiceTask;

import ru.javarush.island.uspenskaya.thread.HerbivoreServiceTask;
import ru.javarush.island.uspenskaya.thread.PlantServiceTask;
import ru.javarush.island.uspenskaya.util.Configger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class GameWorker extends Thread {
    private final GameField gameField;
    private final Day day;
    private boolean isCanceled = false;
    Viewer viewer;


    public GameWorker(GameField gameField, Day day) {
        this.day = day;
        this.gameField = gameField;
        this.viewer = new Viewer(day, gameField);

    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public void run() {
        viewer.showStatistics();
        viewer.showMap();


        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);
        mainPool.scheduleAtFixedRate(() -> {

            try {
                boolean isGood = emulation();

                //if (servicePool.awaitTermination(Configger.getPeriod(), TimeUnit.MILLISECONDS)) {
                if (isGood) {
                    viewer.showStatistics();
                    viewer.showMap();
                }

            } catch (InterruptedException | ExecutionException e) {
                throw new IslandException(e);
            }
        }, Configger.getInitialDelay(), Configger.getPeriod(), TimeUnit.SECONDS);
    }





    public boolean emulation() throws InterruptedException, ExecutionException {
        FutureTask<Integer> futurePlantService = new FutureTask<>(new PlantServiceTask(gameField));
        FutureTask<Integer> futureCarnivoreService = new FutureTask<>(new CarnivoreServiceTask(gameField));
        FutureTask<Integer> futureHerbivoreService = new FutureTask<>(new HerbivoreServiceTask(gameField));
        new Thread(futurePlantService).start();
        new Thread(futureHerbivoreService).start();
        new Thread(futureCarnivoreService).start();

        Integer resultPlantService = futurePlantService.get();
        Integer resultHerbivoreService = futurePlantService.get();
        Integer resultCarnivoreService = futurePlantService.get();
        if (resultPlantService == 1 && resultHerbivoreService == 1 && resultCarnivoreService == 1)
            return true;
        else
        {
            futurePlantService.cancel(true);
            futureCarnivoreService.cancel(true);
            futureHerbivoreService.cancel(true);
            return false;
        }

    }
}

/*    ExecutorService servicePool = Executors.newFixedThreadPool(3);
//QueueTasks.deque.forEach(servicePool::submit);
            listTasks.forEach(servicePool::submit);
                    servicePool.shutdown();

        /*while(!isCanceled) {
            QueueTasks.deque.add(futurePlantService);
            QueueTasks.deque.add(futureCarnivoreService);
            QueueTasks.deque.add(futureHerbivoreService);
            Sleeper.sleep(500);

        List<FutureTask<Integer>> listTasks = new LinkedList<>();
            listTasks.add(futurePlantService);
            listTasks.add(futureCarnivoreService);
            listTasks.add(futureHerbivoreService);
*/










// (futurePlantService.get() == 1 && futureCarnivoreService.get() == 1 && futureHerbivoreService.get() == 1)








