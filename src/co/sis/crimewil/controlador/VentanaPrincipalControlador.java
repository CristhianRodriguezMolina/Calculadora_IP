package co.sis.crimewil.controlador;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import co.sis.crimewil.controlador.ManejadorEscenarios;

public class VentanaPrincipalControlador {

	@FXML
    private JFXButton btnHost;

    @FXML
    private JFXButton btnRed;

	@FXML
    private JFXButton btnConvertir;
	
	/**
	 * instancia del manejador de los escenario
	 */
	private ManejadorEscenarios manejador;
	
	/**
	 * carga la escena del INICIO en el centro del escenario
	 */
	@FXML
	void cargarEscenaInicio(ActionEvent event) {
		this.manejador.cargarEscenaInicio();
	}
	
	/**
	 * carga la escena del HOST en el centro del escenario
	 */
	@FXML
	void cargarEscenaHost(ActionEvent event) {
		this.manejador.cargarEscenaHost();
	}	

	/**
	 * carga la escena de la RED en el centro del escenario
	 */
	@FXML
	 void cargarEscenaRed(ActionEvent event) {
		this.manejador.cargarEscenaRed();
	}
	
	/**
	 * carga la escena del CONVERSOR en el centro del escenario
	 * @param event
	 */
	@FXML
	void cargarEscenaConversor(ActionEvent event) {
		this.manejador.cargarEscenaConversor();
	}
	
	/**
	 * Permite cargar el manejador de escenarios
	 * 
	 * @param manejador
	 */
	public void setManejador(ManejadorEscenarios manejador) {
		this.manejador = manejador;
	}
	
}

