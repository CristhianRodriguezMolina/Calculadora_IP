package co.sis.crimewil.persistencia;

import java.util.ArrayList;

public class Calculadora {
	
	public Calculadora() {}
	
	public static Red calcularDatosHost(int[] direccionHost, int[] mascaraRed) {
		
		int[] direccionRed = co.sis.crimewil.util.Util.calcularDireccionRed(direccionHost, mascaraRed);
		int[] direccionBroadcast = co.sis.crimewil.util.Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = co.sis.crimewil.util.Util.obtenerCantDireccionesIP(mascaraRed);
		ArrayList<int[]> rangoIP = co.sis.crimewil.util.Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP);
		
		return red;
 		
	}
	
	public static Red calcularDatosRed(int[] direccionRed, int[] mascaraRed) {
		
		String mascaraRedDecimal = co.sis.crimewil.util.Util.obtenerDireccionDecimal(direccionRed);
		int[] direccionBroadcast = co.sis.crimewil.util.Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = co.sis.crimewil.util.Util.obtenerCantDireccionesIP(mascaraRed);		
		int cantBitsRed = co.sis.crimewil.util.Util.obtenerCantDatosArray(mascaraRed, 1);
		int cantBitsHosts = co.sis.crimewil.util.Util.obtenerCantDatosArray(mascaraRed, 0);
		ArrayList<int[]> rangoIP = co.sis.crimewil.util.Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP, cantBitsRed, cantBitsHosts, mascaraRedDecimal);
		
		return red;
		
	}
	
	public static int[] convertirDEC_BIN (int dec) {
		return co.sis.crimewil.util.Util.convertirDecimalABinario(dec);
	}
	
	public static String convertirDEC_HEX (int dec) {
		return co.sis.crimewil.util.Util.convertirDecimalAHexa(dec);
	}
	
	public static int convertirBIN_DEC (int bin[]) {
		return co.sis.crimewil.util.Util.convertirBinarioADecimal(bin);
	}
	
	public static String convertirBIN_HEX (int bin[]) {
		return co.sis.crimewil.util.Util.convertirBinarioAHexa(bin);
	}
	
	public static int convertirHEX_DEC (String hex) {
		return co.sis.crimewil.util.Util.convertirHexaADecimal(hex);
	}
	
	public static int[] convertirHEX_BIN (String hex) {
		return co.sis.crimewil.util.Util.convertirHexaABinario(hex);
	}

	@Override
	public String toString() {
		return "Calculadora [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
