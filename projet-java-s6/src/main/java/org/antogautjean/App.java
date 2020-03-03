package org.antogautjean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

	//Nous créons des variable de classes afin de pouvoir y accéder partout
	//Ceci afin de pouvoir y positionner les éléments que nous avons fait
	//Il y a un BorderPane car le conteneur principal de notre IHM
	//est un BorderPane, nous reparlerons de l'objet Stage
	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		//Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("Application de gestion de stock");
		
		//Nous allons utiliser nos fichier FXML dans ces deux méthodes
		initialisationConteneurPrincipal();
		initialisationContenu();
	}

	private void initialisationConteneurPrincipal() {
		//On créé un chargeur de FXML
		FXMLLoader loader = new FXMLLoader();
		//On lui spécifie le chemin relatif à notre classe
		//du fichier FXML a charger : dans le sous-dossier view
		loader.setLocation(App.class.getResource("./src/main/java/org/antogautjean/ConteneurPrincipal.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			//Que nous affectons à notre Stage
			stagePrincipal.setScene(scene);
			//Pour l'afficher
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(App.class.getResource("./src/main/java/org/antogautjean/PersonView.fxml"));
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			conteneurPrincipal.setCenter(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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



		launch(args);
	}
}

