package co.sis.crimewil.util;

public class Util {
	
	/**
	 * 
	 * @param mascara
	 * @return
	 */
	public static int[] obtenerMascara(int mascara) {		
		int[] mascaraRed = new int[32];		
		for (int i = 0; i < mascara; i++) {
			mascaraRed[i] = 1;
		}		
		return mascaraRed;		
	}
	
	/**
	 * 
	 * @param direccionHost
	 * @param mascara
	 * @return
	 */
	public static int[] calcularDireccionRed(int[] direccionHost, int[] mascara) {
		
		int[] direccionRed = new int[32];
		
		for (int i = 0; i < direccionHost.length; i++) {			
			direccionRed[i] = direccionHost[i] * mascara[i];					
		}
		
		return direccionRed;
		
	}
	
	/**
	 * 
	 * @param direccionRed
	 * @param mascaraRed
	 * @return
	 */
	public static int[] calcularDireccionBroadcast(int[] direccionRed, int[] mascaraRed) {
		
		int[] direccionBroadcast = direccionRed;
		for (int i = mascaraRed.length-1; mascaraRed[i] != 1; i--) {			
			direccionBroadcast[i] = 1;					
		}		
		return direccionBroadcast;
		
	}
	
	public static int[] obtenerRangoIPs(int[] direccionRed, int[] direccionBroadcast) {
		
		
		
	}
	
	/**
	 * 
	 * @param mascaraRed
	 * @return
	 */
	public static int obtenerCantDireccionesIP(int[] mascaraRed) {
		
		return (int) (Math.pow(2, obtenerCantDatosArray(mascaraRed, 0)) - 2);
		
	}
	
	/**
	 * 
	 * @param arreglo
	 * @param dato
	 * @return
	 */
	public static int obtenerCantDatosArray(int[] arreglo, int dato) {
		
		int suma = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if(arreglo[i] == dato) {
				suma++;
			}
		}
		return suma;
		
	}
	
	public static int[] sumarBit(int[] direccion)
	
	/**
	 * 
	 * @param a
	 */
	public static void imprimirArreglo(int[] a) {
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]);
		}
		
	}
	
}
