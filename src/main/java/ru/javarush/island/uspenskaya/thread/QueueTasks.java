package ru.javarush.island.uspenskaya.thread;

import java.util.ArrayDeque;
import java.util.concurrent.FutureTask;

public class QueueTasks {

public final static ArrayDeque<FutureTask<Integer>> deque=new ArrayDeque<>();

    public synchronized void add(FutureTask<Integer> future){
        deque.addLast(future);
    }

    public synchronized FutureTask<Integer> pool(){
        return deque.getFirst();
    }
}
