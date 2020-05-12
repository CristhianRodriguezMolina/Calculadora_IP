package co.sis.crimewil.util;

public class Util {
	
	public static int[] obtenerMascara(int mascara) {		
		int[] mascaraRed = new int[32];		
		for (int i = 0; i < mascara; i++) {
			mascaraRed[i] = 1;
		}		
		return mascaraRed;		
	}
	
	public static int[] calcularDireccionRed(int[] direccionHost, int[] mascara) {
		
		int[] direccionRed = new int[32];
		
		for (int i = 0; i < direccionHost.length; i++) {			
			direccionRed[i] = direccionHost[i] * mascara[i];					
		}
		
		return direccionRed;
		
	}
	
	public static int[] calcularDireccionBroadcast(int[] direccionRed, int[] mascaraRed) {
		
		int[] direccionBroadcast = direccionRed;
		for (int i = mascaraRed.length-1; mascaraRed[i] != 1; i--) {			
			direccionBroadcast[i] = 1;					
		}		
		return direccionBroadcast;
		
	}
	
	public static void imprimirArreglo(int[] a) {
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]);
		}
		
	}
	
}
