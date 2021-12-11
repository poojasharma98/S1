package com.stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

public class AggregatorMain {
	public static void main(String[] args) throws IOException {
		// TODO: Insert Code here

		// TODO: Calculate the Mean Aggregate

		// TODO: Calculate the Max Aggregate

		// TODO: Calculate the Min Aggregate

		// Code to read the CSV File
		StockFileReader fileReader = new StockFileReader("marketData.csv");
		// System.out.println(fileReader.getHeaders());
		// System.out.println(fileReader.readFileData());
		List<HashMap<String, Double>> dataResult = populateStockData(fileReader.getHeaders(),
				fileReader.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		if (dataResult != null && dataResult.isEmpty()) {
			out.println("The number of lines in the file are : " + dataResult.size());
		} else {
			out.println("Empty Data Result!");
		}
	}

	/**
	 * Method to concatenate the column names with the values.
	 *
	 * @param headers
	 *            CSV List of headers
	 * @param lines
	 *            Number of Lines
	 * @return {List<HashMap<String, Double>>}
	 */
	public static List<HashMap<String, Double>> populateStockData(List<String> headers, List<String> lines) {
		List<HashMap<String, Double>> list = new ArrayList<>();
		for (int i = 0; i < lines.size(); i++) {
			HashMap<String, Double> m = new HashMap<>();
			String[] oneLine = lines.get(i).split(",");
			for (int j = 0; j < headers.size(); j++) {
				double value = Double.parseDouble(oneLine[j]);
				String key = headers.get(j);
				m.put(key, value);
			}
			list.add(m);
		}
		//System.out.println(list);
		return list;
	}
}
