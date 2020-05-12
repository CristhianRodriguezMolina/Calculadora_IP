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

	public String getDireccionRed() {
		return direccionRed;
	}

	public void setDireccionRed(String direccionRed) {
		this.direccionRed = direccionRed;
	}

	public String getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}

	public int getCantHost() {
		return cantHost;
	}

	public void setCantHost(int cantHost) {
		this.cantHost = cantHost;
	}

	public String[] getRangoIP() {
		return rangoIP;
	}

	public void setRangoIP(String[] rangoIP) {
		this.rangoIP = rangoIP;
	}

	public int getMascaraRed() {
		return mascaraRed;
	}

	public void setMascaraRed(int mascaraRed) {
		this.mascaraRed = mascaraRed;
	}

	public Red() {}
	
}
