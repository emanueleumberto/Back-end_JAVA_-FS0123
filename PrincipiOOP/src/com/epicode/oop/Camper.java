package com.epicode.oop;

public class Camper extends Veicolo {

	private int postiLetto;
	
	public Camper(String marca, String modello, int postiLetto) {
		super(marca, modello);
		this.postiLetto = postiLetto;
	}

	@Override
	public void test() {
		System.out.println("Test Camper!!!!");
	}
	

}
