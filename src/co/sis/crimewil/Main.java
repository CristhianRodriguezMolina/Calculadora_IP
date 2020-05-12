package co.sis.crimewil;

import co.sis.crimewil.controlador.ManejadorEscenarios;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Aplicadion main o ejecutable
 * @author Wilmar Stiven Valencia Cardona
 * @author Cristhian Camilo Rodriguez Molina
 * @version 1.0
 */
public class Main extends Application {

	/**
	 * Metodo principal para la ejecucion del programa
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Inicia la app
	 */
	@Override
	public void start(Stage primaryStage) {

		new ManejadorEscenarios(primaryStage);
	}

}
