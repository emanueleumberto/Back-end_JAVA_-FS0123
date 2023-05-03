package com.epicode.classiJava;

public class Veicolo {
	
	public static int count = 0;
	public  static String type = "Automobile";
	public String modello;
	public String marca;
	public int porte;
	
	public Veicolo() {
		count++;
	}
	
	public Veicolo(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
		count++;
	}
	
	public void printInfo() {
		System.out.println(this.marca + " " + this.modello);
	}
	
	public static void numVeicoli() {
		System.out.println("Veicoli creati: " + count);
	}
}
