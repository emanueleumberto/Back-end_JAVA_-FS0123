package com.epicode.esercizio2;

import java.util.Scanner;

public class MainProject2 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Inserire i Km percorsi: ");
		int kmPercorsi = Integer.parseInt(sc.nextLine());
		System.out.print("Inserire i litri di carburante consumati: ");
		int carburanteConsumato =  Integer.parseInt(sc.nextLine());
		
		try {
			int distanza = kmPercorsi/carburanteConsumato;
			System.out.println("La tua auto percorre " + distanza + " Km al litro");
		} catch (ArithmeticException e) {
			System.out.println("Impossibile che la tua auto consumi 0 carburante!!!");
		} catch (Exception e) {
			System.out.println("ERRORE!!!!");
		}

	}

}
