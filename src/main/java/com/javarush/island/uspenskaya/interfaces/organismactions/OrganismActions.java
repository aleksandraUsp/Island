package com.javarush.island.uspenskaya.interfaces.organismactions;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Initializable;
import com.javarush.island.uspenskaya.interfaces.simpleinterface.Reproducible;

public interface OrganismActions extends Initializable, Reproducible {
    @Override
    void initialize(Cell[][] field);

    @Override
    void reproduct(Cell[][] field);

}
