package com.stock;

import java.io.IOException;
import java.util.List;

class AggregatorProcess<t extends AggregatorFunctions> {
    t aggregator;
    String file;

    public AggregatorProcess(t aggregator, String file) {
        this.aggregator = aggregator;
        this.file = file;
    }

    public double runAggregator(int colIdx) throws IOException {
        StockFileReader fileReader = new StockFileReader(file);
        List<String> lines = fileReader.readFileData();
        colIdx--;
        for (String line : lines) {
            String[] numbers = line.split(",");
            double value = Double.parseDouble(numbers[colIdx]);
            aggregator.add(value);
        }
        double number = aggregator.calculate();
        return number;
    }

}
