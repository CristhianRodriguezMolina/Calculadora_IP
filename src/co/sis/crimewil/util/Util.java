package co.sis.crimewil.util;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	/**
	 * 
	 * @param direccionRed
	 * @param direccionBroadcast
	 * @return
	 */
	public static ArrayList<int[]> obtenerRangoIPs(int[] direccionRed, int[] direccionBroadcast) {
		
		//REPRESENTA UN BINARIO EN 32 BITS
		int[] one = new int[32];
		one[31] = 1;
		
		ArrayList<int[]> rango = new ArrayList<int[]>();
		
		//SE SUMA UN BIT A LA DIRECCION DE RED Y SE RESTA UNO A LA DE BROADCAST
		int[] direccionAct = sumarBit(direccionRed, one);
		while(!direccionAct.equals(direccionBroadcast)) {
			rango.add(direccionAct);
			direccionAct = sumarBit(direccionAct, one);
		}		
					
		return rango;
		
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
	 * @param direccion
	 * @return
	 */
	public static String obtenerDireccionDecimal(int[] direccion) {
		
		String salidaDecimal = "";
		for (int i = 0; i < direccion.length; i+=8) {
			if(i == 0) {
				salidaDecimal += Integer.parseInt(convertirArregloAString((Arrays.copyOfRange(direccion, i, i+8))), 2);
			}else {
				salidaDecimal += "." + Integer.parseInt(convertirArregloAString((Arrays.copyOfRange(direccion, i, i+8))), 2);
			}			
		}
		return salidaDecimal;
		
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
	
	/**
	 * Metodo para convetir un numero de base decimal a base binaria
	 * @param numero en base decimal
	 * @return un arreglo de bits
	 */
	public static int[] convertirDecimalABinario(int decimal) 
	{
		String binario = Integer.toString(decimal, 2); //DECIMAL A BINARIO
		int bits = binario.length();
		int[] arrBits = new int[bits];
		for(int i = 0; i < bits; i++) 
		{
			int bit = binario.charAt(i) - 48;
			arrBits[i] = bit;
		}
		
		return arrBits;
	}
	
	public static int convertirBinarioADecimal(int[] binario) 
	{
		String cadenaBinario = convertirArregloAString(binario);
		int decimal = Integer.parseInt(cadenaBinario, 2); //BINARIO A DECIMAL
		return decimal;
	}
	
	/**
	 * Metodo que me extiende el arreglo de bits a un numero dado de bits para representar
	 * @param arrBits
	 * @param representacion
	 * @return el numero con la nueva representacipn
	 */
	public static int[] extenderRepresentacionBinaria(int[] arrBits, int representacion) 
	{
		if(arrBits.length < representacion) 
		{
			int[] newArrBits = new int[representacion];
			for(int i = arrBits.length - 1, j = representacion - 1; i >= 0; i--, j--) 
			{
				newArrBits[j] = arrBits[i];
			}
			return newArrBits;
		}
		else 
		{
			return arrBits;
		}
		
	}
	
	
	
	/**
	 * 
	 * @param numBinario1
	 * @param numBinario2
	 * @return
	 */
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
	 
	/**
	 * 
	 * @param numBinario1
	 * @param numBinario2
	 * @return
	 */
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
	
	public static String convertirArregloAString(int[] arreglo) {
		
		String salida = "";
		for (int i = 0; i < arreglo.length; i++) {
			salida += arreglo[i];					
		}
		return salida;
		
	}
	
	/**
	 * 
	 * @param a
	 */
	public static void imprimirArreglo(int[] a) {
		String msj = "[ ";
		if(a.length > 0) 
		{
			for(int i = 0; i < a.length; i++) {
				msj += a[i] + ", ";
			}
			
			msj = msj.substring(0, msj.length() - 2);
		}
		msj += " ]";
		
		System.out.println(msj);
	}
	
}
