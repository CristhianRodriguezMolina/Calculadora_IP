package co.sis.crimewil.util;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		
		int[] direccionBroadcast = direccionRed.clone();
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
		while(!Arrays.equals(direccionAct, direccionBroadcast)) {
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
				salidaDecimal += convertirBinarioADecimal(convertirArregloAString((Arrays.copyOfRange(direccion, i, i + 8))));
			}else {
				salidaDecimal += "." + convertirBinarioADecimal(convertirArregloAString(Arrays.copyOfRange(direccion, i, i + 8)));
			}			
		}
		return salidaDecimal;
		
	}	
	
	/**
	 * 
	 * @param ip1
	 * @param ip2
	 * @param ip3
	 * @param ip4
	 * @return
	 */
	public static int[] obtenerDireccionBinaria(int ip1, int ip2, int ip3, int ip4) {

		int[] direccionBinaria = new int[32];
		
		int[] numeroBinario = convertirDecimalABinario(ip1);
		int[] numeroBinario2 = convertirDecimalABinario(ip2);
		int[] numeroBinario3 = convertirDecimalABinario(ip3);
		int[] numeroBinario4 = convertirDecimalABinario(ip4);
		
		numeroBinario = extenderRepresentacionBinaria(numeroBinario, 8);
		numeroBinario2 = extenderRepresentacionBinaria(numeroBinario2, 8);
		numeroBinario3 = extenderRepresentacionBinaria(numeroBinario3, 8);
		numeroBinario4 = extenderRepresentacionBinaria(numeroBinario4, 8);
		
		int i = direccionBinaria.length-1;
		
		for (int j = numeroBinario4.length-1; j >= 0; j--) {
			direccionBinaria[i] = numeroBinario4[j];
			i--;
		}
		
		i = 23;
		
		for (int j = numeroBinario3.length-1; j >= 0; j--) {
			direccionBinaria[i] = numeroBinario3[j];
			i--;
		}
		
		i = 15;
		
		for (int j = numeroBinario2.length-1; j >= 0; j--) {
			direccionBinaria[i] = numeroBinario2[j];
			i--;
		}
		
		i = 7;
		
		for (int j = numeroBinario2.length-1; j >= 0; j--) {
			direccionBinaria[i] = numeroBinario[j];
			i--;
		}
		
		return direccionBinaria;
		
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
	
	/**
	 * Metodo para convetir un numero de base decimal a base binaria
	 * @param numero en base decimal
	 * @return un cadena con el numero binario
	 */
	public static String convertirDecimalAStringBinario(int decimal) 
	{
		String binario = Integer.toString(decimal, 2); //DECIMAL A BINARIO
		return binario;
	}
	
	
	/**
	 * Metodo para convertir un numero de base binario a decimal
	 * @param cadena del numero binario
	 * @return el numero en decimal
	 */
	public static int convertirBinarioADecimal(String binario) 
	{
		int decimal = Integer.parseInt(binario, 2); //BINARIO A DECIMAL
		return decimal;
	}
	
	/**
	 * Metodo para convertir un numero de base binario a decimal
	 * @param arreglo del bits del numero
	 * @return el numero en decimal
	 */
	public static int convertirBinarioADecimal(int[] binario) 
	{
		String cadenaBinario = convertirArregloAString(binario);
		int decimal = Integer.parseInt(cadenaBinario, 2); //BINARIO A DECIMAL
		return decimal;
	}
	
	/**
	 * Metodo para convertir un numero en base decimal a hexadecimal
	 * @param el numero en base decimal
	 * @return el numero en base hexadecimal
	 */
	public static String convertirDecimalAHexa(int decimal) 
	{
		String hexa = Integer.toHexString(decimal); //DECIMAL A HEXA
		hexa = hexa.toUpperCase();
		return hexa;
	}
	
	/**
	 * Metodo para convertir un numero en base hexadecimal a decimal
	 * @param el numero en base hexadecimal
	 * @return el numero en base decimal
	 */
	public static int convertirHexaADecimal(String hexa) 
	{
		int decimal = Integer.parseInt(hexa, 16); //HEXA A DECIMAL
		return decimal;
	}
	
	
	/**
	 * Metodo para convetir un numero en base binaria a hexadecimal
	 * @param arreglo de bits
	 * @return el numero en hexadecimal
	 */
	public static String convertirBinarioAHexa(int[] binario) 
	{
		int decimal = convertirBinarioADecimal(binario);
		String hexa = convertirDecimalAHexa(decimal);
		hexa = hexa.toUpperCase();
		return hexa;
	}
	
	/**
	 * Metodo para convetir un numero en base binaria a hexadecimal
	 * @param cadena del numero binario
	 * @return el numero en hexadecimal
	 */
	public static String convertirBinarioAHexa(String binario) 
	{
		int decimal = convertirBinarioADecimal(binario);
		String hexa = convertirDecimalAHexa(decimal);
		hexa = hexa.toUpperCase();
		return hexa;
	}
	
	/**
	 * Metodo para convetir un numero en base hexadecimal a binaria
	 * @param el numero en base hexa
	 * @return arreglo de bits
	 */
	public static int[] convertirHexaABinario(String hexa) 
	{
		int decimal = convertirHexaADecimal(hexa);
		int[] binario = convertirDecimalABinario(decimal);
		return binario;
	}
	
	/**
	 * Metodo para convetir un numero en base hexadecimal a binaria
	 * @param el numero en base hexa
	 * @return cadena del numero binario
	 */
	public static String convertirHexaAStringBinario(String hexa) 
	{
		int decimal = convertirHexaADecimal(hexa);
		String binario = convertirDecimalAStringBinario(decimal);
		return binario;
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
	
	public static boolean isValidIp(String ip1, String ip2, String ip3, String ip4) 
	{
		
		boolean valid = false;
		if((ip1 == null || ip1.equals("")) && (ip2 == null || ip2.equals("")) &&
			(ip3 == null || ip3.equals("")) && (ip4 == null || ip4.equals("")))
		{
			valid = false;
		}
		
		try {
			int ip1Decimal = Integer.parseInt(ip1);
			int ip2Decimal = Integer.parseInt(ip2);
			int ip3Decimal = Integer.parseInt(ip3);
			int ip4Decimal = Integer.parseInt(ip4);
			
			if((ip1Decimal >= 0 && ip1Decimal <= 255) && (ip2Decimal >= 0 && ip2Decimal <= 255) 
				&& (ip3Decimal >= 0 && ip3Decimal <= 255) && (ip4Decimal >= 0 && ip4Decimal <= 255)) 
			{
				valid = true;
			}
			return valid;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Metodo que me dice si una direccion es de una red dada la mascara de subred
	 * @param direccionRed
	 * @param mascaraRed
	 * @return
	 */
	public static boolean validarDireccionRed(int[] direccionRed, int mascaraRed) 
	{
		for(int i = mascaraRed; i < 32; i++) 
		{
			if(direccionRed[i] == 1) 
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Metodo que me dice si una direccion es de una red dada la mascara de subred
	 * @param direccionRed
	 * @param mascaraRed
	 * @return
	 */
	public static boolean validarDireccionHost(int[] direccionHost, int mascaraRed) 
	{
		int sum = 0;
		for(int i = mascaraRed; i < 32; i++) 
		{
			sum += direccionHost[i];
		}
		
		if(sum == 0 || sum == (32 - mascaraRed)) 
		{
			return false;
		}
		return true;
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
	
	/**
	 * 
	 * @param arreglo
	 * @return
	 */
	public static String convertirArregloAString(int[] arreglo) {
		
		String salida = "";
		for (int i = 0; i < arreglo.length; i++) {
			salida += arreglo[i];					
		}
		return salida;
		
	}
	
	/**
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static int[] concatenarArray(int[] o1, int[] o2)
	{
		int[] ret = new int[o1.length + o2.length];
 
		System.arraycopy(o1, 0, ret, 0, o1.length);
		System.arraycopy(o2, 0, ret, o1.length, o2.length);
 
		return ret;
	}
	
	
	public static boolean isHexaNumber(String number) 
	{
		if(number == null || number.equals("")) 
		{
			return false;
		}
		number = number.toUpperCase();
		char caracter;
		for(int i = 0; i < number.length(); i++) 
		{
			caracter = number.charAt(i);
			// si el caracter esta entre [0-10] y [A-F]
			if(!((caracter >= 49 && caracter <= 57) || (caracter >= 65 && caracter <= 70))) 
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Metodo que me indica si la cadena contiene solo digitos de base binaria
	 * @param number
	 * @return true si es un n�mero binario, de la contrario false
	 */
	public static boolean isBinaryNumber(String number) 
	{
		if(number == null || number.equals("")) 
		{
			return false;
		}
		for(int i = 0; i < number.length(); i++) 
		{
			if(!(number.charAt(i) == '0' || number.charAt(i) == '1')) 
			{
				return false;
			}
		}
		return true;
	}
	
	
		
	
	
	/**
	 * Metodo que me indica si la cadena es un n�mero
	 * @param number
	 * @return true si es un n�mero, de lo contrario false
	 */
	public static boolean isNumeric(String number) 
	{
		if(number == null || number.equals("")) 
		{
			return false;
		}
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * permite mostrar un texto informativo en pantalla
	 * @param titulo subtitulo de la alerta
	 * @param mensaje mensaje principal
	 */
	public static void mostrarMensajeAlerta( String titulo, String mensaje ) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Conversor");
		alert.setHeaderText(titulo);
		alert.setContentText(mensaje);
		alert.showAndWait();	
	}
	
	/**
	 * permite mostrar un texto de error en pantalla
	 * @param titulo subtitulo de la alerta
	 * @param mensaje mensaje principal
	 */
	public static void mostrarMensajeError( String titulo, String mensaje ) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Calculadora IP");
		alert.setHeaderText(titulo);
		alert.setContentText(mensaje);
		alert.showAndWait();	
	}
	
	/**
	 * Metodo que me permite imprimir un arreglo 
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
