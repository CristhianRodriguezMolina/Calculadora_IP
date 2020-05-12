package co.sis.crimewil.persistencia;



public class Calculadora {
	
	public Calculadora() {}
	
	public Red calcularDatos(int[] direccionHost, int[] mascaraRed) {
		
		int[] direccionRed = co.sis.crimewil.util.Util.calcularDireccionRed(direccionHost, mascaraRed);
		int[] direccionBroadcast = co.sis.crimewil.util.Util.calcularDireccionBroadcast(direccionRed, mascaraRed);
		int cantDireccionesIP = co.sis.crimewil.util.Util.obtenerCantDireccionesIP(mascaraRed);
		
		
		Red red = new Red(direccionRed, mascaraRed, direccionBroadcast, cantDireccionesIP, rangoIP);
 		
	}

}
