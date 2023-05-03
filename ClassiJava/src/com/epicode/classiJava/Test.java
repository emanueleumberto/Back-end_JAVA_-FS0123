package com.epicode.classiJava;

public class Test {
	
	public String txt = "Class Scope";
	public int num = 25;
	// public String txt; Errore!!!!
	
	public void stampaTxt() {
		System.out.println(this.txt);
	}
	
	public void mioTest() {
		String txt = "Method Scope";
		txt = txt.toLowerCase();
		System.out.println(txt);
		
		{
			System.out.println(txt);
			System.out.println(num);
			String testo = "Scope Blocco";
		}
		// System.out.println(testo); Errore
		System.out.println(num); 
	}
	
	
	
}
