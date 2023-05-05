package com.epicode.oop;

public class Automobile extends Veicolo implements Navigatore, Altra{
	
	private int numPorte;
	
	// Overloading dei costruttori
	public Automobile(String marca, String modello, int numPorte) {
		super(marca, modello);
		this.numPorte = numPorte;
	}
	
	//Gestione Metodi sottoclasse
	
	// Nuovo metodo
	public void abc(String s) {
		System.out.println("Test " + s + "!!!!");
	}
	// Metodo con lo stesso nome del metodo ereditato ma con firma diversa (Overloading)
	public void test(String s) {
		System.out.println(super.getMarca() + " " + super.getModello());
	}
	// Riscrittura del Metodo ereditato dalla superclasse (Override)
	@Override
	public void test() {
		System.out.println("Test Automobile!!!!");
	}
	
	public void start() {
		System.out.println("Automobile " + this.getModello() + " start!!!");
	}

	@Override
	public String toString() {
		return super.toString() + " numPorte=" + numPorte + " Tipo Automobile";
	}

	@Override
	public void startNavigatore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopNavigatore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avviaMappa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aggiornaNavigatore() {
		// TODO Auto-generated method stub
		
	}

	



}
