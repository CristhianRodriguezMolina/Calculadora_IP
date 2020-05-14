package co.sis.crimewl.Junit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import co.sis.crimewil.persistencia.Calculadora;
import co.sis.crimewil.persistencia.Red;

class CalculadoraTest {
	
	private Calculadora calculadora = new Calculadora();
	
	@Test
	public void calcularDatosHost() {
		int direccionHost[] = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0}; //195.50.100.8
		int mascaraRed[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		Red resultado = calculadora.calcularDatosHost(direccionHost, mascaraRed);
		
		int[] direccionRedEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0}; //195.50.100.0
		int[] mascaraRedEsperado = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		int[] direccionBroadcastEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1}; //195.50.100.255
		int cantDireccionesIPEsperado = 254;
		int[] rangoInicioEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1}; //195.50.100.1
		int[] rangoFinalEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,0}; //195.50.100.254
		
		assertTrue(Arrays.equals(direccionRedEsperado, resultado.getDireccionRed()));
		assertTrue(Arrays.equals(mascaraRedEsperado, resultado.getMascaraRed()));
		assertTrue(Arrays.equals(direccionBroadcastEsperado, resultado.getDireccionBroadcast()));
		assertTrue(cantDireccionesIPEsperado == resultado.getCantHost());
		assertTrue(Arrays.equals(rangoInicioEsperado, resultado.getRangoIP().get(0)));
		assertTrue(Arrays.equals(rangoFinalEsperado, resultado.getRangoIP().get(resultado.getRangoIP().size()-1)));
	}

}
