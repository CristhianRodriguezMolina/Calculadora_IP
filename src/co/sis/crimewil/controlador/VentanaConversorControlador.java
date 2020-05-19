package co.sis.crimewil.controlador;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import co.sis.crimewil.util.Util;

public class VentanaConversorControlador {

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXButton btnCalcular;

    @FXML
    private JFXComboBox<String> cbxBase;

    @FXML
    private JFXTextField txtDecimal;

    @FXML
    private JFXTextField txtBinario;

    @FXML
    private JFXTextField txtHexa;
    
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
		
		String[] bases = {"Decimal", "Binario", "Hexadecimal"};		
		for (int i = 0; i < bases.length; i++) {
			cbxBase.getItems().add(bases[i]);
		}
		cbxBase.getSelectionModel().select(0);
		
	}
	
    @FXML
    void convertirUnidades(ActionEvent event) {

    	switch(cbxBase.getValue()) {
    		case "Decimal":
    			txtNumero.setText(txtNumero.getText().trim());
    			if(!txtNumero.getText().equals("")) 
    			{
	    			if(Util.isNumeric(txtNumero.getText())) {
	    				txtDecimal.setText(txtNumero.getText());
	    				int decimal = Integer.parseInt(txtNumero.getText());
	    				String binario = Util.convertirDecimalAStringBinario(decimal);
	    				txtBinario.setText(binario);
	    				String hexa = Util.convertirDecimalAHexa(decimal);
	    				txtHexa.setText(hexa);    				
	    			}
	    			else 
	    			{
	    				Util.mostrarMensajeAlerta("¡Atención!", "El número ingresado no es un "
    							+ "número válido para la base Decimal.");
	    			}
    			}
    			else 
    			{
    				resetText();
    			}
    			break;
    		case "Binario":
    			txtNumero.setText(txtNumero.getText().trim());
    			if(!txtNumero.getText().equals("")) 
    			{
    				if(Util.isBinaryNumber(txtNumero.getText())) {
    					int decimal = Util.convertirBinarioADecimal(txtNumero.getText());
    					txtDecimal.setText(decimal + "");
    					txtBinario.setText(txtNumero.getText());
    					String hex = Util.convertirDecimalAHexa(decimal);
    					txtHexa.setText(hex);			
    				}
    				else 
    				{
    					Util.mostrarMensajeAlerta("¡Atención!", "El número ingresado no es un "
    							+ "número válido para la base Binaria.");
    				}    				
    			}
    			else 
    			{
    				resetText();
    			}
    			break;
    		case "Hexadecimal":
    			txtNumero.setText(txtNumero.getText().trim());
    			if(!txtNumero.getText().equals("")) 
    			{
    				if(Util.isHexaNumber(txtNumero.getText())) 
    				{
    					int decimal = Util.convertirHexaADecimal(txtNumero.getText());
    					txtDecimal.setText(decimal + "");
    					String binario = Util.convertirDecimalAStringBinario(decimal);
    					txtBinario.setText(binario + "");
    					txtHexa.setText(txtNumero.getText().toUpperCase());    					
    				}
    				else 
    				{
    					Util.mostrarMensajeAlerta("¡Atención!", "El número ingresado no es un "
    							+ "número válido para la base Hexadecimal.");
    				}
    			}
    			else 
    			{
    				resetText();
    			}
    			break;
    		default:
    			Util.mostrarMensajeError("¡Error!", "Error al convertir.");
    	}
    	
    }
    
    public void resetText() 
    {
    	txtDecimal.setText("");
    	txtBinario.setText("");
    	txtHexa.setText("");
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
