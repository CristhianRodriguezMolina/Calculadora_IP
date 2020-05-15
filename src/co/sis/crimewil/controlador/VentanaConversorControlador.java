package co.sis.crimewil.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

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
		
	}
	
    @FXML
    void convertirUnidades(ActionEvent event) {

    	switch(cbxBase.getValue()) {
    		case "Decimal":
    			txtDecimal.setText(txtNumero.getText());
    			txtBinario.setText(Integer.toString(Integer.parseInt(txtNumero.getText()), 2));
    			txtHexa.setText(Integer.toHexString(Integer.parseInt(txtNumero.getText())));
    			break;
    		case "Binario":
    			txtDecimal.setText(Integer.parseInt(txtNumero.getText(), 2)+"");
    			txtBinario.setText(txtNumero.getText());
    			int decimalAux = Integer.parseInt(txtNumero.getText(), 2);
    			System.out.println(decimalAux);
    			txtHexa.setText(Integer.toHexString(decimalAux));
    			break;
    		case "Hexadecimal":
    			txtDecimal.setText(Integer.parseInt(txtNumero.getText(), 16)+"");
    			int decimalAux2 = Integer.parseInt(txtNumero.getText(), 16);
    			System.out.println(decimalAux2);
    			txtBinario.setText(Integer.toString(decimalAux2, 2)+"");
    			txtHexa.setText(txtNumero.getText());
    			break;
    		default:
    			System.out.println("ERROR AL CONVERTIR");
    	}
    	
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
