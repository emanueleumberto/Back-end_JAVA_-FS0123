package com.epicode.project.classes;

import com.epicode.project.interfaces.Navigatore;

public class Smartphone implements Navigatore {
	
	private String marca;
	private String modello;
	private int memoria;
	private String os;
	
	public Smartphone(String marca, String modello, int memoria, String os) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.memoria = memoria;
		this.os = os;
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

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		return "Smartphone [marca=" + marca + ", modello=" + modello + ", memoria=" + memoria + ", os=" + os + "]";
	}
	
	@Override
	public void avviaNavigatore() {
		System.out.println("Navigatore avviato su " + this.getModello());
	}

	@Override
	public void impostaMappa() {
		System.out.println("Imposta mappa su " + this.getModello());
	}

	@Override
	public void aggiornaNavigatore() {
		System.out.println("Navigatore aggiornato su " + this.getModello());
	}
	
}
