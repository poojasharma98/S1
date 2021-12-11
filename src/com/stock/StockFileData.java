package com.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Helper Class
 */
class StockFileData {

    List<HashMap<String, Double>> data = new ArrayList<>();

    public void addData(List<HashMap<String, Double>> dataIn) {
        data = dataIn;
    }

    public void printData() {
        System.out.println(data);
    }
   
}
