package co.sis.crimewil.persistencia;

public class Red {

	private String direccionRed;
	private String broadcast;
	private int cantHost;
	private String[] rangoIP;
	private int mascaraRed;
	
	public Red(String direccionRed, int mascaraRed) {
		this.direccionRed = direccionRed;
		this.mascaraRed = mascaraRed;
	}
	
	
	
}
