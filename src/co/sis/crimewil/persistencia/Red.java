package co.sis.crimewil.persistencia;

public class Red {

	private int direccionRed[];
	private int mascaraRed[];
	private int direccionBroadcast[];
	private int cantHost;
	private int rangoIP[][];

	public Red() {}
	
	public Red(int[] direccionRed, int[] mascaraRed, int[] direccionBroadcast, int cantHost, int[][] rangoIP) {
		this.direccionRed = direccionRed;
		this.mascaraRed = mascaraRed;
		this.direccionBroadcast = direccionBroadcast;
		this.cantHost = cantHost;
		this.rangoIP = rangoIP;
	}

	public int[] getDireccionRed() {
		return direccionRed;
	}

	public void setDireccionRed(int[] direccionRed) {
		this.direccionRed = direccionRed;
	}

	public int[] getMascaraRed() {
		return mascaraRed;
	}

	public void setMascaraRed(int[] mascaraRed) {
		this.mascaraRed = mascaraRed;
	}

	public int[] getDireccionBroadcast() {
		return direccionBroadcast;
	}

	public void setDireccionBroadcast(int[] direccionBroadcast) {
		this.direccionBroadcast = direccionBroadcast;
	}

	public int getCantHost() {
		return cantHost;
	}

	public void setCantHost(int cantHost) {
		this.cantHost = cantHost;
	}

	public int[][] getRangoIP() {
		return rangoIP;
	}

	public void setRangoIP(int[][] rangoIP) {
		this.rangoIP = rangoIP;
	}

}
