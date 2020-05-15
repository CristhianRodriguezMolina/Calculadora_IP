package co.sis.crimewil.controlador;

import java.util.Arrays;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class VentanaRedControlador {

    @FXML
    private JFXTextField txtIP1;

    @FXML
    private JFXTextField txtIP2;

    @FXML
    private JFXTextField txtIP3;

    @FXML
    private JFXTextField txtIP4;

    @FXML
    private JFXButton btnCalcular;

    @FXML
    private JFXComboBox<Integer> cbxMascara;

    @FXML
    private JFXTextField txtMascaraRed;

    @FXML
    private JFXTextField txtDireccionBroadcast;

    @FXML
    private JFXTextField txtBitsRed;

    @FXML
    private JFXTextField txtBitsHosts;

    @FXML
    private JFXTextField txtCantHost;

    @FXML
    private JFXTextField txtRangoIP;

    @FXML
    private JFXComboBox<String> cbxRangoIP;
    /**
	 * instancia del manejador de los escenario
	 */
	private ManejadorEscenarios manejador;
	/**
	 * escenario
	 */
	private Stage escenario;
	
	/**
	 * Metodo para inicializar ciertos parametros por defecto en la Ventana 
	 */
	@FXML
	void initialize() {
		
		Integer[] mascaras = {8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};		
		for (int i = 0; i < mascaras.length; i++) {
			cbxMascara.getItems().add(mascaras[i]);
		}		
		
	}
	
	/**
	 * Metodo para calcular los datos de la red dada una direccion de host
	 * @param event
	 */
	@FXML
    void calcularRed(ActionEvent event) {

    }

    /**
	 * permite obtener una instancia del escenario general
	 * 
	 * @param manejador
	 */
	public void setEscenarioInicial(ManejadorEscenarios manejador, Stage escenario) {
		this.manejador = manejador;
		this.escenario = escenario;
	}
}
