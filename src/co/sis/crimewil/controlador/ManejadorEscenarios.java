package co.sis.crimewil.controlador;

import java.io.IOException;

import co.sis.crimewil.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ManejadorEscenarios
{
	
	/**
	 * Escenario principal
	 */
	private Stage escenario;
	
	/**
	 * Tipo de panel inicial
	 */
	private BorderPane anchorPanel;
	
	/**
	 * Recibe el escenario principal de la aplicacion
	 * 
	 * @param escenario inicial
	 */
	public ManejadorEscenarios(Stage escenario) 
	{
		this.escenario = escenario;
		try {
			// se inicializa el escenario
			escenario.setTitle("Analizador Lexico de la Universidad del Quindio");
			
			// se carga la vista
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("./vista/ventanaPrincipal.fxml"));
			
			anchorPanel = (BorderPane) loader.load();
			
			VentanaPrincipalControlador controlador = loader.getController();
			controlador.setManejador(this);
			
			// se carga la escena
			Scene scene = new Scene(anchorPanel);
			escenario.setScene(scene);
			escenario.show();
			
//		cargarEscenario();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
