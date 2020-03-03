package org.antogautjean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class App {

	public static void main(String[] args) throws IOException {

		HashMap<String, Product> stock = new HashMap<>(1);

		System.out.println( "Reading CSV file" );
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		BufferedReader csvReader = new BufferedReader(new FileReader("./src/main/java/org/antogautjean/files/elements.csv"));

		String row;
		csvReader.readLine();

		while ((row = csvReader.readLine()) != null) {

			try {

				String[] line = row.split(";");

				String code = line[0];
				String name = line[1];

				Integer quantity = Integer.parseInt(line[2]);
				Unit unit = Unit.strToUnit(line[3]);

				Product current = new Product(code, name, quantity, unit, null, null, null);
				stock.put(code, current);
			}
			catch (Exception e){
				e.getMessage();
			}
		}
		csvReader.close();

		csvReader = new BufferedReader(new FileReader("./src/main/java/org/antogautjean/files/prix.csv"));
		csvReader.readLine();

		while ((row = csvReader.readLine()) != null) {

			String[] line = row.split(";");

			if (stock.get(line[0]) != null){

				if (!line[1].equals("NA"))
					stock.get(line[0]).setBuyPrice((double) Integer.parseInt(line[1]));
				if (!line[2].equals("NA"))
					stock.get(line[0]).setSellPrice((double) Integer.parseInt(line[2]));

				stock.get(line[0]).setDemand((double) Integer.parseInt(line[3]));
			}
		}

		System.out.println(stock);


		csvReader = new BufferedReader(new FileReader("./src/main/java/org/antogautjean/files/chaines.csv"));
		csvReader.readLine();

		while ((row = csvReader.readLine()) != null) {
			String[] line = row.split(";");

			String code = line[0];
			String name = line[1];
			String input = line[2];
			String output = line[3];
			String duration = line[4];
			String qualified = line[5];
			String unqualified = line[6];

			System.out.println(input);

			String[] dataIn = input.split(",");

			System.out.println(dataIn.length);


			break;
		}
		csvReader.close();

	}
}

