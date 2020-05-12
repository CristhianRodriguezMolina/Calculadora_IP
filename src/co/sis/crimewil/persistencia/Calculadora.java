package co.sis.crimewil.persistencia;



public class Calculadora {
	
	public Calculadora() {}
	
	public Red calcularDatosRed(int[] direccionHost, int[] mascaraRed) {
		
		int[] direccionRed = co.sis.crimewil.util.Util.calcularDireccionRed(direccionHost, mascaraRed);
		int[] direccionBroadcast = co.sis.crimewil.util.Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = co.sis.crimewil.util.Util.obtenerCantDireccionesIP(mascaraRed);
		int[][] rangoIP = co.sis.crimewil.util.Util.obtenerRangoIPs(direccionRed, direccionBroadcast);
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP);
		
		return red;
 		
	}

}
