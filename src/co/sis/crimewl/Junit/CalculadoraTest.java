package co.sis.crimewl.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import co.sis.crimewil.persistencia.Calculadora;
import co.sis.crimewil.persistencia.Red;

class CalculadoraTest {
	
	private Calculadora calculadora = new Calculadora();
	
	@Test
	public void testCalcularDatosHost() {
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
	
	@Test
	public void testCalcularDatosRed() {
		int direccionRed[] = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0}; //195.50.100.0
		int mascaraRed[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		Red resultado = calculadora.calcularDatosRed(direccionRed, mascaraRed);
		
		int[] direccionRedEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0}; //195.50.100.0
		int[] mascaraRedEsperado = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		int[] direccionBroadcastEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1}; //195.50.100.255
		int cantDireccionesIPEsperado = 254;
		int[] rangoInicioEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1}; //195.50.100.1
		int[] rangoFinalEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,0}; //195.50.100.254
		int cantBitsRed = 24;
		int cantBitsHosts = 8;
		String mascaraRedDecimal = "195.50.100.0";
		
		assertTrue(Arrays.equals(direccionRedEsperado, resultado.getDireccionRed()));
		assertTrue(Arrays.equals(mascaraRedEsperado, resultado.getMascaraRed()));
		assertTrue(Arrays.equals(direccionBroadcastEsperado, resultado.getDireccionBroadcast()));
		assertTrue(cantDireccionesIPEsperado == resultado.getCantHost());
		assertTrue(Arrays.equals(rangoInicioEsperado, resultado.getRangoIP().get(0)));
		assertTrue(Arrays.equals(rangoFinalEsperado, resultado.getRangoIP().get(resultado.getRangoIP().size()-1)));
		assertEquals(cantBitsRed, resultado.getCantBitsRed());
		assertEquals(cantBitsHosts, resultado.getCantBitsHosts());
		assertEquals(mascaraRedDecimal, resultado.getMascaraRedDecimal());
	}
	
	@Test
	public void tesConvertirDEC_BIN() {
		int dec = 10;
		int bin[] = calculadora.convertirDEC_BIN(dec);
		
		int binEsperado[] = {1,0,1,0};
		
		assertTrue(Arrays.equals(binEsperado, bin));
	}
	
	@Test
	public void tesConvertirDEC_HEX() {
		int dec = 10;
		String hex = calculadora.convertirDEC_HEX(dec);
		assertEquals("a", hex);
	}
	
	@Test
	public void tesConvertirBIN_DEC() {
		int[] bin = {0,0,0,0,1,0,1,0};
		int dec = calculadora.convertirBIN_DEC(bin);
		assertEquals(10, dec);
	}
	
	@Test
	public void tesConvertirBIN_HEX() {
		int[] bin = {0,0,0,0,1,0,1,0};
		String hex = calculadora.convertirBIN_HEX(bin);
		assertEquals("a", hex);
	}
	
	@Test
	public void tesConvertirHEX_DEC() {
		String hex = "a";
		int dec = calculadora.convertirHEX_DEC(hex);
		assertEquals(10, dec);
	}
	
	@Test
	public void tesConvertirHEX_BIN() {
		String hex = "a";
		int bin[] = calculadora.convertirHEX_BIN(hex);
		
		int binEsperado[] = {1,0,1,0};
		
		assertTrue(Arrays.equals(binEsperado, bin));
	}

}
