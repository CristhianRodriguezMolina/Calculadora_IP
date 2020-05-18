package co.sis.crimewil.persistencia;

import java.util.ArrayList;
import java.util.Arrays;

import co.sis.crimewil.util.Util;

public class Red {

	private int direccionRed[];
	private int mascaraRed[];
	private int direccionBroadcast[];
	private int cantHost;
	private ArrayList<int[]> rangoIP;
	private int cantBitsRed;
	private int cantBitsHosts;
	private String mascaraRedDecimal;

	public Red() {}
	
	public Red(int[] direccionRed, int[] mascaraRed, int[] direccionBroadcast, int cantHost, ArrayList<int[]> rangoIP) {
		this.direccionRed = direccionRed;
		this.mascaraRed = mascaraRed;
		this.direccionBroadcast = direccionBroadcast;
		this.cantHost = cantHost;
		this.rangoIP = rangoIP;
	}

	public Red(int[] direccionRed, int[] mascaraRed, int[] direccionBroadcast, int cantHost, ArrayList<int[]>rangoIP, int cantBitsRed, int cantBitsHosts, String mascaraRedDecimal) {
		this.direccionRed = direccionRed;
		this.mascaraRed = mascaraRed;
		this.direccionBroadcast = direccionBroadcast;
		this.cantHost = cantHost;
		this.rangoIP = rangoIP;
		this.cantBitsRed = cantBitsRed;
		this.cantBitsHosts = cantBitsHosts;
		this.mascaraRedDecimal = mascaraRedDecimal;
	}
	
	public ArrayList<String> getRangoIPString(){
		
		ArrayList<String> salida = new ArrayList<String>();
		
		for (int i = 0; i < rangoIP.size(); i++) {
			salida.add(Util.obtenerDireccionDecimal(rangoIP.get(i)));
		}
		
		return salida;
		
	}
	
	public String getRangoIPAsignables() {
		
		String salida = Util.obtenerDireccionDecimal(rangoIP.get(1));
		salida += " - ";
		salida += Util.obtenerDireccionDecimal(rangoIP.get(rangoIP.size()-2));
		return  salida;
				
	}
	
	public int getCantBitsRed() {
		return cantBitsRed;
	}

	public void setCantBitsRed(int cantBitsRed) {
		this.cantBitsRed = cantBitsRed;
	}

	public int getCantBitsHosts() {
		return cantBitsHosts;
	}

	public void setCantBitsHosts(int cantBitsHosts) {
		this.cantBitsHosts = cantBitsHosts;
	}

	public String getMascaraRedDecimal() {
		return mascaraRedDecimal;
	}

	public void setMascaraRedDecimal(String mascaraRedDecimal) {
		this.mascaraRedDecimal = mascaraRedDecimal;
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

	public ArrayList<int[]> getRangoIP() {
		return rangoIP;
	}

	public void setRangoIP(ArrayList<int[]> rangoIP) {
		this.rangoIP = rangoIP;
	}

	@Override
	public String toString() {
		return "Red [direccionRed=" + Arrays.toString(direccionRed) + ", mascaraRed=" + Arrays.toString(mascaraRed)
				+ ", direccionBroadcast=" + Arrays.toString(direccionBroadcast) + ", cantHost=" + cantHost
				+ ", rangoIP=" + rangoIP + ", cantBitsRed=" + cantBitsRed + ", cantBitsHosts=" + cantBitsHosts
				+ ", mascaraRedDecimal=" + mascaraRedDecimal + "]";
	}

	
}
