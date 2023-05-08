package com.epicode.project.classes;

public abstract class Veicolo {
	
	private static int numero;
	private String marca;
	private String modello;

	public Veicolo(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
		numero++;
	}

	public static int getNumero() {
		return numero;
	}
	
	public String getMarca() {
		// Controlli
		return marca;
	}
	public void setMarca(String marca) {
		// Controlli
		this.marca = marca;
	}
	public String getModello() {
		// Controlli
		return modello;
	}
	public void setModello(String modello) {
		// Controlli
		this.modello = modello;
	}

	@Override
	public String toString() {
		return "Veicolo [marca=" + marca + ", modello=" + modello + "]";
	}
	
	
	

}
