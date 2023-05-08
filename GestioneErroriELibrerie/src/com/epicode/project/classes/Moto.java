package com.epicode.project.classes;

public class Moto extends Veicolo {
	
	private int numPosti;

	public Moto(String marca, String modello, int numPosti) {
		super(marca, modello);
		this.numPosti = numPosti;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	@Override
	public String toString() {
		return "Moto [numPosti=" + numPosti + ", Veicolo=" + super.toString() + "]";
	}
	
	

}
