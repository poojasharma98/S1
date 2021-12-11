package com.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper Abstract Class
 */
abstract class AggregatorFunctions {

    List<Double> numbers = new ArrayList<>();

    public void add(double number) {
        numbers.add(number);
    }

    public abstract double calculate();

    public abstract List<Double> getValues();
}
