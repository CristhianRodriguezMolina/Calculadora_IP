package co.sis.crimewil;

public class mainPruebas {

	/**
	 * Metodo principal para la ejecucion del programa
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {0,0,0,0,0,0,1,1};
		int[] b = {1,1,0,1,0,0,0,0};
		int[] c = {1,1,1,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0};
		int[] d = {1,1,1,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,1};
		int[] one = new int[32];
		one[31] = 1;
		one[30] = 1;
		
		//co.sis.crimewil.util.Util.imprimirArreglo(co.sis.crimewil.util.Util.calcularDireccionBroadcast(b, c));
		//System.out.println();
		//System.out.println(co.sis.crimewil.util.Util.obtenerCantDireccionesIP(c));
		//System.out.println();
		//co.sis.crimewil.util.Util.imprimirArreglo(co.sis.crimewil.util.Util.sumarBit(c, one));
		//System.out.println();
		//co.sis.crimewil.util.Util.imprimirArreglo(co.sis.crimewil.util.Util.restarBit(a, b));
		int[][] result = co.sis.crimewil.util.Util.obtenerRangoIPs(c, d);
		co.sis.crimewil.util.Util.imprimirArreglo(result[0]);
		System.out.println();
		co.sis.crimewil.util.Util.imprimirArreglo(result[1]);
	}
	
}
