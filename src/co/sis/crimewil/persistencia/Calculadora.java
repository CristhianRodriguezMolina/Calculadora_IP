package co.sis.crimewil.persistencia;

import java.util.ArrayList;

import co.sis.crimewil.util.Util;

public class Calculadora {
	
	public Calculadora() {}
	
	public static Red calcularDatosHost(int[] direccionHost, int[] mascaraRed) {
		
		int[] direccionRed = Util.calcularDireccionRed(direccionHost, mascaraRed);
		int[] direccionBroadcast = Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = Util.obtenerCantDireccionesIP(mascaraRed);
		ArrayList<int[]> rangoIP = Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP);
		
		return red;
 		
	}
	
	public static Red calcularDatosRed(int[] direccionRed, int[] mascaraRed) {
		
		String mascaraRedDecimal = Util.obtenerDireccionDecimal(mascaraRed);
		int[] direccionBroadcast = Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = Util.obtenerCantDireccionesIP(mascaraRed);		
		int cantBitsRed = Util.obtenerCantDatosArray(mascaraRed, 1);
		int cantBitsHosts = Util.obtenerCantDatosArray(mascaraRed, 0);
		ArrayList<int[]> rangoIP = Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP, cantBitsRed, cantBitsHosts, mascaraRedDecimal);
		
		return red;
		
	}
	
	public static int[] convertirDEC_BIN (int dec) {
		return Util.convertirDecimalABinario(dec);
	}
	
	public static String convertirDEC_HEX (int dec) {
		return Util.convertirDecimalAHexa(dec);
	}
	
	public static int convertirBIN_DEC (int bin[]) {
		return Util.convertirBinarioADecimal(bin);
	}
	
	public static String convertirBIN_HEX (int bin[]) {
		return Util.convertirBinarioAHexa(bin);
	}
	
	public static int convertirHEX_DEC (String hex) {
		return Util.convertirHexaADecimal(hex);
	}
	
	public static int[] convertirHEX_BIN (String hex) {
		return Util.convertirHexaABinario(hex);
	}

	@Override
	public String toString() {
		return "Calculadora [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
