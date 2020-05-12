package co.sis.crimewil.util;

public class Util {
	
	public static int[] obtenerMascara(int mascara) {		
		int[] mascaraRed = new int[32];		
		for (int i = 0; i < mascara; i++) {
			mascaraRed[i] = 1;
		}		
		return mascaraRed;		
	}
	
}
