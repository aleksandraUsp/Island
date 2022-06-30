package com.javarush.island.uspenskaya.entities.field;

import java.util.concurrent.atomic.AtomicInteger;

public class Day {
    private final AtomicInteger number=new AtomicInteger(1);
    private final String name;

    public Day() {
        this.name = "Day"+number.getAndIncrement();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
