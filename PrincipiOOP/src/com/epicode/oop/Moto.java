package com.epicode.oop;

public class Moto extends Veicolo {

	private int cilindrata;

	public Moto(String marca, String modello, int cilindrata) {
		super(marca, modello);
		this.cilindrata = cilindrata;
	}
	
	public void start() {
		System.out.println("Moto " + this.getModello() + " start!!!");
	}
	
	@Override
	public void test() {
		System.out.println("Test Moto!!!!");
	}

}
