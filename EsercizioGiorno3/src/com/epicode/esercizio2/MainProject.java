package com.epicode.esercizio2;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci numero intero: ");
		int num = sc.nextInt();
		String risposta = "";

		switch (num) {
			case 0: risposta = "Zero"; break;
			case 1: risposta = "Uno"; break;
			case 2: risposta = "Due"; break;
			case 3: risposta = "Tre"; break;
			default: risposta = "ERRRORE!!!";  break;
		}

		System.out.println(risposta);
	}

}
