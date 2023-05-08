package com.epicode.project.classes;

import com.epicode.project.interfaces.Navigatore;

public class Automobile extends Veicolo implements Navigatore {
	
	private int numPorte;

	public Automobile(String marca, String modello, int numPorte) {
		super(marca, modello);
		this.numPorte = numPorte;
	}

	public int getNumPorte() {
		return numPorte;
	}

	public void setNumPorte(int numPorte) {
		this.numPorte = numPorte;
	}

	@Override
	public String toString() {
		return "Automobile [numPorte=" + numPorte + ", Veicolo=" + super.toString() + "]";
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
