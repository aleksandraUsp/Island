package ru.javarush.island.uspenskaya.services;

import ru.javarush.island.uspenskaya.entities.field.Day;
import ru.javarush.island.uspenskaya.entities.field.GameField;
import ru.javarush.island.uspenskaya.entities.field.Viewer;
import ru.javarush.island.uspenskaya.exeption.IslandException;
import ru.javarush.island.uspenskaya.thread.CarnivoreServiceTask;
import ru.javarush.island.uspenskaya.thread.QueueTasks;
import ru.javarush.island.uspenskaya.thread.HerbivoreServiceTask;
import ru.javarush.island.uspenskaya.thread.PlantServiceTask;
import ru.javarush.island.uspenskaya.util.Configger;
import ru.javarush.island.uspenskaya.util.Sleeper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class GameWorker {
    private final GameField gameField;
    private final Day day;
    private boolean isCanceled = false;


    //private volatile boolean isCancel = false;

    public GameWorker(GameField gameField, Day day) {
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


        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(1);

        /*while(!isCanceled) {
            QueueTasks.deque.add(futurePlantService);
            QueueTasks.deque.add(futureCarnivoreService);
            QueueTasks.deque.add(futureHerbivoreService);
            Sleeper.sleep(500);
*/
        List<FutureTask<Integer>> listTasks = new LinkedList<>();
            listTasks.add(futurePlantService);
            listTasks.add(futureCarnivoreService);
            listTasks.add(futureHerbivoreService);


        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(3);
            //QueueTasks.deque.forEach(servicePool::submit);
            listTasks.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(Configger.getPeriod(), TimeUnit.MILLISECONDS)) {
                    viewer.showStatistics();
                    viewer.showMap();
                }

            } catch (InterruptedException  e) {
                throw new IslandException(e);
            }
        }, Configger.getInitialDelay(), Configger.getPeriod() , TimeUnit.SECONDS);


    }
}




// (futurePlantService.get() == 1 && futureCarnivoreService.get() == 1 && futureHerbivoreService.get() == 1)








