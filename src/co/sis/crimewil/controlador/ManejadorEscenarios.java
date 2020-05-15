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
	private BorderPane borderPanel;
	
	/**
	 * Tipo de panel de INICIO
	 */
	private FXMLLoader inicioPanel;
	
	/**
	 * Tipo de panel de HOST
	 */
	private FXMLLoader hostPanel;
	
	/**
	 * Tipo de panel RED
	 */
	private FXMLLoader redPanel;
	
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
			escenario.setTitle("Calculadora IP");
			
			// se carga la vista
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("./vista/VentanaPrincipal.fxml"));
			
			borderPanel = (BorderPane) loader.load();
			
			VentanaPrincipalControlador controlador = loader.getController();
			controlador.setManejador(this);
			
			// se carga la escena
			Scene scene = new Scene(borderPanel);
			escenario.setScene(scene);
			escenario.show();
			
			cargarEscenaInicio();		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * carga la escena del INICIO en el centro del escenario
	 */
	public void cargarEscenaInicio() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("./vista/VentanaInicio.fxml"));
			BorderPane panel = (BorderPane) loader.load();
			borderPanel.setCenter(panel);

			this.hostPanel = loader;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * carga la escena del HOST en el centro del escenario
	 */
	public void cargarEscenaHost() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("./vista/VentanaHost.fxml"));
			BorderPane panel = (BorderPane) loader.load();
			borderPanel.setCenter(panel);

			VentanaHostControlador controlador = loader.getController();
			controlador.setEscenarioInicial(this, escenario);

			this.hostPanel = loader;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * carga la escena de la RED en el centro del escenario
	 */
	public void cargarEscenaRed() {
			
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("./vista/VentanaRed.fxml"));
			BorderPane panel = (BorderPane) loader.load();
			borderPanel.setCenter(panel);

			VentanaRedControlador controlador = loader.getController();
			controlador.setEscenarioInicial(this, escenario);

			this.redPanel = loader;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * carga la escena deL CONVERSOR en el centro del escenario
	 */
	public void cargarEscenaConversor() {
			
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("./vista/VentanaConversor.fxml"));
			BorderPane panel = (BorderPane) loader.load();
			borderPanel.setCenter(panel);

			VentanaConversorControlador controlador = loader.getController();
			controlador.setEscenarioInicial(this, escenario);

			this.redPanel = loader;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
