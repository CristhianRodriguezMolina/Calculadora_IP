package co.sis.crimewil.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import co.sis.crimewil.persistencia.Calculadora;
import co.sis.crimewil.persistencia.Red;

class CalculadoraTest {
	
	@Test
	public void testCalcularDatosHost_1() {
		int direccionHost[] = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0}; //195.50.100.8
		int mascaraRed[] 	= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		Red resultado = Calculadora.calcularDatosHost(direccionHost, mascaraRed);
		
		int[] direccionRedEsperado 			= {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0}; //195.50.100.0
		int[] mascaraRedEsperado 			= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		int[] direccionBroadcastEsperado 	= {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1}; //195.50.100.255
		int cantDireccionesIPEsperado = 254;
		int[] rangoInicioEsperado 			= {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1}; //195.50.100.1
		int[] rangoFinalEsperado 			= {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,0}; //195.50.100.254
		
		assertTrue(Arrays.equals(direccionRedEsperado, resultado.getDireccionRed()));
		assertTrue(Arrays.equals(mascaraRedEsperado, resultado.getMascaraRed()));
		assertTrue(Arrays.equals(direccionBroadcastEsperado, resultado.getDireccionBroadcast()));
		assertTrue(cantDireccionesIPEsperado == resultado.getCantHost());
		assertTrue(Arrays.equals(rangoInicioEsperado, resultado.getRangoIP().get(0)));
		assertTrue(Arrays.equals(rangoFinalEsperado, resultado.getRangoIP().get(resultado.getRangoIP().size()-1)));
	}
	
	@Test
	public void testCalcularDatosHost_2() {
		int direccionHost[] = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0}; //192.168.0.10
		int mascaraRed[] 	= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}; //21 bits
		Red resultado = Calculadora.calcularDatosHost(direccionHost, mascaraRed);
		
		int[] direccionRedEsperado 			= {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //192.168.0.0
		int[] mascaraRedEsperado 			= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}; //21 bits
		int[] direccionBroadcastEsperado 	= {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1}; //192.168.7.255
		int cantDireccionesIPEsperado = 2048;
		int[] rangoInicioEsperado 			= {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}; //192.168.0.1
		int[] rangoFinalEsperado 			= {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0}; //192.168.7.254
		
		assertTrue(Arrays.equals(direccionRedEsperado, resultado.getDireccionRed()));
		assertTrue(Arrays.equals(mascaraRedEsperado, resultado.getMascaraRed()));
		assertTrue(Arrays.equals(direccionBroadcastEsperado, resultado.getDireccionBroadcast()));
		assertTrue(cantDireccionesIPEsperado == resultado.getCantHost());
		assertTrue(Arrays.equals(rangoInicioEsperado, resultado.getRangoIP().get(0)));
		assertTrue(Arrays.equals(rangoFinalEsperado, resultado.getRangoIP().get(resultado.getRangoIP().size()-1)));
	}
	
	@Test
	public void testCalcularDatosRed_1() {
		int direccionRed[] = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0}; //195.50.100.0
		int mascaraRed[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		Red resultado = Calculadora.calcularDatosRed(direccionRed, mascaraRed);
		
		int[] direccionRedEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0}; //195.50.100.0
		int[] mascaraRedEsperado = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}; //24 bits
		int[] direccionBroadcastEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1}; //195.50.100.255
		int cantDireccionesIPEsperado = 254;
		int[] rangoInicioEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1}; //195.50.100.1
		int[] rangoFinalEsperado = {1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,0}; //195.50.100.254
		int cantBitsRed = 24;
		int cantBitsHosts = 8;
		String mascaraRedDecimal = "255.255.255.0";
		
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
	public void testCalcularDatosRed_2() {
		int direccionRed[] = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //192.168.0.0
		int mascaraRed[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}; //21 bits
		Red resultado = Calculadora.calcularDatosRed(direccionRed, mascaraRed);
		
		int[] direccionRedEsperado = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //192.168.0.0
		int[] mascaraRedEsperado = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}; //21 bits
		int[] direccionBroadcastEsperado = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1}; //192.168.7.255
		int cantDireccionesIPEsperado = 2046;
		int[] rangoInicioEsperado = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //192.168.0.0
		int[] rangoFinalEsperado = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0}; //192.168.7.254
		int cantBitsRed = 21;
		int cantBitsHosts = 11;
		String mascaraRedDecimal = "255.255.248.0";
		
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
	public void tesConvertirDEC_BIN_1() {
		int dec = 10;
		int bin[] = Calculadora.convertirDEC_BIN(dec);
		
		int binEsperado[] = {1,0,1,0};
		
		assertTrue(Arrays.equals(binEsperado, bin));
	}
	@Test
	public void tesConvertirDEC_BIN_2() {
		int dec = 10;
		int bin[] = Calculadora.convertirDEC_BIN(dec);
		
		int binEsperado[] = {1,0,0,0};
		
		assertTrue(Arrays.equals(binEsperado, bin));
	}
	
	@Test
	public void tesConvertirDEC_HEX_1() {
		int dec = 10;
		String hex = Calculadora.convertirDEC_HEX(dec);
		assertEquals("A", hex);
	}
	
	@Test
	public void tesConvertirDEC_HEX_2() {
		int dec = 10;
		String hex = Calculadora.convertirDEC_HEX(dec);
		assertEquals("B", hex);
	}
	
	@Test
	public void tesConvertirBIN_DEC_1() {
		int[] bin = {0,0,0,0,1,0,1,0};
		int dec = Calculadora.convertirBIN_DEC(bin);
		assertEquals(10, dec);
	}
	
	@Test
	public void tesConvertirBIN_DEC_2() {
		int[] bin = {0,0,0,0,1,0,1,0};
		int dec = Calculadora.convertirBIN_DEC(bin);
		assertEquals(8, dec);
	}
	
	@Test
	public void tesConvertirBIN_HEX_1() {
		int[] bin = {0,0,0,0,1,0,1,0};
		String hex = Calculadora.convertirBIN_HEX(bin);
		assertEquals("A", hex);
	}
	
	@Test
	public void tesConvertirBIN_HEX_2() {
		int[] bin = {0,0,0,0,1,0,1,0};
		String hex = Calculadora.convertirBIN_HEX(bin);
		assertEquals("D", hex);
	}
	
	@Test
	public void tesConvertirHEX_DEC_1() {
		String hex = "A";
		int dec = Calculadora.convertirHEX_DEC(hex);
		assertEquals(10, dec);
	}
	
	@Test
	public void tesConvertirHEX_DEC_2() {
		String hex = "A";
		int dec = Calculadora.convertirHEX_DEC(hex);
		assertEquals(15, dec);
	}
	
	@Test
	public void tesConvertirHEX_BIN_1() {
		String hex = "A";
		int bin[] = Calculadora.convertirHEX_BIN(hex);
		
		int binEsperado[] = {1,0,1,0};
		
		assertTrue(Arrays.equals(binEsperado, bin));
	}
	
	@Test
	public void tesConvertirHEX_BIN_2() {
		String hex = "A";
		int bin[] = Calculadora.convertirHEX_BIN(hex);
		
		int binEsperado[] = {1,0,0,1};
		
		assertTrue(Arrays.equals(binEsperado, bin));
	}

}
