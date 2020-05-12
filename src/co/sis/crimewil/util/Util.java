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
	
	public static int[] restarBit(int[] numBinario1, int[]numBinario2) {
		int salida[] = new int[32];
		for (int i = salida.length - 1; i >= 0 ; i--) {
			int elemento = numBinario1[i] - numBinario2[i];
			if (elemento == 1 || elemento == 0) {
				salida[i] = elemento;
			}else {
				salida[i] = 1;
				for (int j = i-1; numBinario1[j] >= 0 ; j--) {
					if(numBinario1[j] == 0) {
						numBinario1[j] = 1;
					}else {
						numBinario1[j] = 0;
						break;
					}
				}
			}
		}
		return salida;
	}
	 
	public static int[] sumarBit(int[] numBinario1, int[]numBinario2) {
		int salida[] = new int[32];
		int carry = 0;
		for (int i = salida.length - 1; i >= 0 ; i--) {
			int elemento = numBinario1[i] + numBinario2[i] + carry;
			if(elemento == 2) {
				salida[i] = 0;
				carry = 1;
			}else
			if(elemento == 3) {
				salida[i] = 1;
				carry = 1;
			}else {
				salida[i] = elemento;
				carry = 0;
			}
		}
		return salida;
	}
	
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
