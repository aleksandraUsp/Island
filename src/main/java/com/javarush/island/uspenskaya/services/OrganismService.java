package com.javarush.island.uspenskaya.services;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.interfaces.organismactions.OrganismActions;


public abstract class OrganismService implements OrganismActions {
    public OrganismService() {
    }

    @Override
    public void initialize(Cell[][] field) {
    }


}
