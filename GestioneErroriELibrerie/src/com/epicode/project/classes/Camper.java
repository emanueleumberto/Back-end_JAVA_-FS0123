package com.epicode.project.classes;

import com.epicode.project.interfaces.Navigatore;

public class Camper extends Veicolo implements Navigatore {
	
	private int postiLetto;

	public Camper(String marca, String modello, int postiLetto) {
		super(marca, modello);
		this.postiLetto = postiLetto;
	}

	public int getPostiLetto() {
		return postiLetto;
	}

	public void setPostiLetto(int postiLetto) {
		this.postiLetto = postiLetto;
	}

	@Override
	public String toString() {
		return "Camper [postiLetto=" + postiLetto + ", Veicolo=" + super.toString() + "]";
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
