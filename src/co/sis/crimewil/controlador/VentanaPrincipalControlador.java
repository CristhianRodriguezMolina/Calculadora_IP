package co.sis.crimewil.controlador;

import co.sis.crimewil.controlador.ManejadorEscenarios;

public class VentanaPrincipalControlador {

	/**
	 * instancia del manejador de los escenario
	 */
	private ManejadorEscenarios manejador;
	
	
	/**
	 * Permite cargar el manejador de escenarios
	 * 
	 * @param manejador
	 */
	public void setManejador(ManejadorEscenarios manejador) {
		this.manejador = manejador;
	}
}

