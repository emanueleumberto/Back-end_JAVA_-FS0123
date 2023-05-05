package com.epicode.oop;

public abstract class Veicolo {
	
	public final String TIPO = "Veicolo";
	public static int numVeicoli = 0;
	protected String marca;
	protected String modello;

	public Veicolo(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
		numVeicoli++;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	public static void veicoliCreati() {
		System.out.println(numVeicoli);
	}
	
	public abstract void test();

	@Override
	public String toString() {
		return "marca=" + marca + ", modello=" + modello;
	}
	
	

}
