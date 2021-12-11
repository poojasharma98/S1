package com.stock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StockFileReader {

	static String filePath = "marketData.csv";

	public StockFileReader(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getHeaders() throws IOException {
		String lines = readFirstLine(filePath);
		String[] header = lines.split(",");
		return Arrays.asList(header);
	}

	/*public static void main(String[] args) throws IOException {
		StockFileReader s = new StockFileReader(filePath);
		System.out.println(s.readFirstLine(filePath));
		System.out.println(s.getHeaders());
		System.out.println(s.readFileData());

	}*/

	/**
	 * Read the CSV File Line by Line
	 *
	 * @param path
	 *            File Path
	 * @return {String}
	 * @throws IOException
	 */
	public String readFirstLine(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String firstLine = br.readLine();
		return firstLine;
	}

	public List<String> readFileData() throws IOException {
		List<String> lines = new ArrayList<>();
		try (BufferedReader bfr = new BufferedReader(new FileReader(filePath))) {
			bfr.readLine();
			String line = null;
			while ((line = bfr.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}
}
