package co.sis.crimewil;

import java.util.*;

public class mainPruebas {

	/**
	 * Metodo principal para la ejecucion del programa
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] a = {0,0,0,0,0,0,1,1};
//		int[] b = {1,1,0,1,0,0,0,0};
//		int[] c = {1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0};
//		int[] d = {1,1,1,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,1};
//		int[] one = new int[32];
//		one[31] = 1;
//		one[30] = 1;
		
		//co.sis.crimewil.util.Util.imprimirArreglo(co.sis.crimewil.util.Util.calcularDireccionBroadcast(b, c));
		//System.out.println();
		//System.out.println(co.sis.crimewil.util.Util.obtenerCantDireccionesIP(c));
		//System.out.println();
		//co.sis.crimewil.util.Util.imprimirArreglo(co.sis.crimewil.util.Util.sumarBit(c, one));
		//System.out.println();
		//co.sis.crimewil.util.Util.imprimirArreglo(co.sis.crimewil.util.Util.restarBit(a, b));
//		int[][] result = co.sis.crimewil.util.Util.obtenerRangoIPs(c, d);
//		co.sis.crimewil.util.Util.imprimirArreglo(result[0]);
//		System.out.println();
//		co.sis.crimewil.util.Util.imprimirArreglo(result[1]);
		
		
//		System.out.println(Integer.toString(168, 2)); //DECIMAL A BINARIO
//		System.out.println(Integer.parseInt("11111111", 2)); //BINARIO A DECIMAL
//		System.out.println(Integer.toHexString(15)); //DECIMAL A HEXA
//		System.out.println(Integer.parseInt("F", 16)); //HEXA A DECIMAL
//		
//		System.out.println(co.sis.crimewil.util.Util.convertirArregloAString(a));
//		
//		System.out.println(co.sis.crimewil.util.Util.obtenerDireccionDecimal(c));
		
		
		for(int i = 0; i < 255;i++) 
		{
			System.out.println("Numero en decimal: " + i);
			int[] binario = co.sis.crimewil.util.Util.convertirDecimalABinario(i);
			co.sis.crimewil.util.Util.imprimirArreglo(binario);
			binario = co.sis.crimewil.util.Util.extenderRepresentacionBinaria(binario, 8);
			co.sis.crimewil.util.Util.imprimirArreglo(binario);
			int decimal = co.sis.crimewil.util.Util.convertirBinarioADecimal(binario);
			System.out.println("Numero en decimal: " + decimal);
			String hexa = co.sis.crimewil.util.Util.convertirDecimalAHexa(decimal);
			System.out.println("Numero en hexa: " + hexa);
			int decimal2 = co.sis.crimewil.util.Util.convertirHexaADecimal(hexa);
			System.out.println("Numero en hexa: " + decimal2);
			System.out.println("");
		}
		
		
	}
	
}
