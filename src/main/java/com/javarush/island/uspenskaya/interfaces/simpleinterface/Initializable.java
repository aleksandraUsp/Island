package com.javarush.island.uspenskaya.interfaces.simpleinterface;

import com.javarush.island.uspenskaya.entities.field.Cell;
import com.javarush.island.uspenskaya.entities.field.GameField;
import com.javarush.island.uspenskaya.entities.organizms.Organism;

import java.util.Queue;

public interface Initializable {
    void initialize(Cell[][] field);
}
