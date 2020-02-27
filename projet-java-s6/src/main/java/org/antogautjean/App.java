package org.antogautjean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Reading CSV file" );
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader csvReader = new BufferedReader(new FileReader("./src/test/java/org/antogautjean/files/chaines.csv"));

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(";");
            System.out.println(row);

            String code = data[0];
            String nom
        }
        csvReader.close();
    }
}
