package com.epicode.test;

public class MainProjectTest {

	public static void main(String[] args) {

		for (int i = 1; i <= 7; i++) {
		
			System.out.println(i + " - " + getGiornoSettimana(i));
		}
		
		System.out.println(getStagione(3));

	}
	
	public static String getGiornoSettimana(int giorno) {
		
		switch (giorno) {
			case 1: return "Lunedi";
			case 2: return "Martedi";
			case 3: return "Mercoledi";
			case 4: return "Giovedi";
			case 5: return "Venerdi";
			case 6: return "Sabato";
			case 7: return "Domenica";
			default: return "Valore errato";
		}

	}
	
	public static String getStagione(int mese) {
		
		switch (mese) {
			case 12: case 1: case 2: return "Inverno";
			case 3: 
			case 4: 
			case 5: return "Primavera";
			case 6: 
			case 7: 
			case 8: return "Estate";
			case 9: 
			case 10: 
			case 11: return "Autunno";
			default: return "Valore errato";
		}

	}

}
