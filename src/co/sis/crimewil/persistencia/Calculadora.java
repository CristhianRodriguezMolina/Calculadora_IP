package co.sis.crimewil.persistencia;

import java.util.ArrayList;

public class Calculadora {
	
	public Calculadora() {}
	
	public Red calcularDatosHost(int[] direccionHost, int[] mascaraRed) {
		
		int[] direccionRed = co.sis.crimewil.util.Util.calcularDireccionRed(direccionHost, mascaraRed);
		int[] direccionBroadcast = co.sis.crimewil.util.Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = co.sis.crimewil.util.Util.obtenerCantDireccionesIP(mascaraRed);
		ArrayList<int[]> rangoIP = co.sis.crimewil.util.Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP);
		
		return red;
 		
	}
	
	public Red calcularDatosRed(int[] direccionRed, int[] mascaraRed) {
		
		String mascaraRedDecimal = co.sis.crimewil.util.Util.obtenerDireccionDecimal(direccionRed);
		int[] direccionBroadcast = co.sis.crimewil.util.Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = co.sis.crimewil.util.Util.obtenerCantDireccionesIP(mascaraRed);		
		int cantBitsRed = co.sis.crimewil.util.Util.obtenerCantDatosArray(direccionRed, 1);
		int cantBitsHosts = co.sis.crimewil.util.Util.obtenerCantDatosArray(direccionRed, 0);
		ArrayList<int[]> rangoIP = co.sis.crimewil.util.Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP, cantBitsRed, cantBitsHosts, mascaraRedDecimal);
		
		return red;
		
	}

}
