package com.epicode.esercizio1;

import java.util.Random;
import java.util.Scanner;

public class MainProject1 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] arrInteri = creaArrayNumeriCasuali();
		stampaArray(arrInteri);
		leggiNumeroPosizione(arrInteri);

	}
	
	private static void leggiNumeroPosizione(int[] arr) {
		int numero, posizione = 0; 
		boolean continua = true;
		do {
			try {
			System.out.print("Inserisci un numero. 0 per uscire: ");
			numero = Integer.parseInt(sc.nextLine());
			
			if(numero != 0) {
				
				try {
					System.out.print("Inserisci la posizione da sostituire: ");
					posizione = Integer.parseInt(sc.nextLine());
					
					arr[posizione] = numero;
					stampaArray(arr);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Posizione fuori dai limiti dell'array: " + posizione);
				} 
			} else {
				continua = false;
			}
			} catch (NumberFormatException e) {
				System.out.println("Valore errato " + posizione);
			}
			
		} while(continua);
	}
	
	private static void stampaArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.println("Numero " +  arr[j] + " indice " + j);	
		}
	}
	
	private static int[] creaArrayNumeriCasuali() {
		int[] arr = new int[5];
		Random rand = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10)+1; // genera un valore casuale tra 0 - 10
		}
		return arr;
	}

}
