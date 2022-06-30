package com.javarush.island.uspenskaya.entities.field;

import com.javarush.island.uspenskaya.services.CarnivoreService;
import com.javarush.island.uspenskaya.services.HerbivoreService;
import com.javarush.island.uspenskaya.services.PlantService;

public class Viewer {
    private Day day;
    private final Cell[][]field;

    public Viewer(Day day,Cell[][]field) {
        this.day = day;
        this.field = field;
    }
    void print(Day day){


    }
}
