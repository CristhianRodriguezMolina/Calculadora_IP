package co.sis.crimewil.controlador;

import java.util.Arrays;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import co.sis.crimewil.persistencia.Calculadora;
import co.sis.crimewil.persistencia.Red;
import co.sis.crimewil.util.Util;

import javafx.collections.FXCollections;
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
		int ini = 8;
		int fin = 30;		
		for (int i = ini; i <= fin; i++) {
			cbxMascara.getItems().add(i);
		}		
		cbxMascara.getSelectionModel().select(16);
		
	}
	
	/**
	 * Metodo para calcular los datos de la red dada una direccion de host
	 * @param event
	 */
	@FXML
    void calcularRed(ActionEvent event) {
		
		txtIP1.setText(txtIP1.getText().trim());
		txtIP2.setText(txtIP2.getText().trim());
		txtIP3.setText(txtIP3.getText().trim());
		txtIP4.setText(txtIP4.getText().trim());
		cbxRangoIP.getItems().clear();
		if(!(txtIP1.getText().equals("") || txtIP2.getText().equals("") || 
				txtIP3.getText().equals("") || txtIP4.getText().equals(""))) 
		{
			if(Util.isValidIp(txtIP1.getText(), txtIP2.getText(),txtIP3.getText(), txtIP4.getText())) 
			{
				int[] direccionRed = Util.obtenerDireccionBinaria(
											Integer.parseInt(txtIP1.getText()), 
											Integer.parseInt(txtIP2.getText()), 
											Integer.parseInt(txtIP3.getText()), 
											Integer.parseInt(txtIP4.getText())
											);
				
				int[] mascaraRed = Util.obtenerMascara(cbxMascara.getValue());
				
				if(Util.validarDireccionRed(direccionRed, cbxMascara.getValue())) 
				{					
					Red red = Calculadora.calcularDatosRed(direccionRed, mascaraRed);
					
					txtMascaraRed.setText(red.getMascaraRedDecimal());
					txtDireccionBroadcast.setText(Util.obtenerDireccionDecimal(red.getDireccionBroadcast()));
					txtBitsRed.setText(red.getCantBitsRed()+"");
					txtBitsHosts.setText(red.getCantBitsHosts()+"");
					txtCantHost.setText(red.getCantHost()+"");
					txtRangoIP.setText(red.getRangoIPAsignables());
					cbxRangoIP.setItems(FXCollections.observableList(red.getRangoIPString()));
					cbxRangoIP.getSelectionModel().select(0);					
				}
				else 
				{
					Util.mostrarMensajeAlerta("¡Atención!", "la dirección ingresada no es la dirección de una red");
					resetText();
				}
				
			}
			else 
			{
				Util.mostrarMensajeAlerta("¡Atención!", "la red ingresada no es válida");
				resetText();
			}
		}
		else 
		{
			Util.mostrarMensajeAlerta("¡Atención!", "Por favor, complete todos los campos.");
			resetText();
		}
		
    }
	
	public void resetText() 
	{
		txtMascaraRed.setText("");
		txtDireccionBroadcast.setText("");
		txtBitsRed.setText("");
		txtBitsHosts.setText("");
		txtCantHost.setText("");
		txtRangoIP.setText("");
		cbxRangoIP.getItems().clear();
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
