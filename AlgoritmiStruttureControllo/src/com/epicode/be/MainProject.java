package com.epicode.be;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		int x = 0;
		
		// Struttura di controllo if-elseif-else
		if(x > 10) {
			// istruzioni da eseguire de la condizione è vera
			System.out.println("Maggiore!!");
		} else if(x == 10) {
			// istruzioni da eseguire de la condizione è falsa
			System.out.println("Uguale!!");
		} else {
			// istruzioni da eseguire de la condizione è falsa
			System.out.println("Minore!!");
		}
		
		// Struttura di controllo switch
		int giornoSettimana = 4;
		
		switch (giornoSettimana) {
			case 1: System.out.println("Lunedi"); break;
			case 2: System.out.println("Martedi"); break;
			case 3: System.out.println("Mercoledi"); break;
			case 4: System.out.println("Giovedi"); break;
			case 5: System.out.println("Venerdi"); break;
			case 6: System.out.println("Sabato"); break;
			case 7: System.out.println("Domenica"); break;
			default: System.out.println("Valore errato"); break;
		}
		System.out.println("---------");
		// Struttura iterativa While
		
		int i = 0;
		while (i < 5) {
			System.out.println(i + " - Ciao!");
			i++;
		}
		
		int j = 0;
		while (true) {
			System.out.println(j + " - Ciao!");
			j++;
			if(j >= 5) {
				break;
			}
		}
		
		System.out.println("---------");
		// Struttura iterativa Do While
		
		int y = 5;
		while (y < 5) {
			System.out.println(y + " - Ciao while!");
			y++;
		}
		
		int k = 5;
		do {
			System.out.println(k + " - Ciao do while!");
			k++;
		} while (k < 5);
		

		int scelta;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("inserisci un numero: ");
			scelta = sc.nextInt();
		} while (scelta != 0);
		
		System.out.println("---------");
		// Struttura iterativa For
		
		for (int l = 0; l < 10 ; l++) {
			if(l == 2) {
				continue;
			}
			
			if(l == 5) {
				break;
			}
			System.out.println(l + " - Ciao for!");
		}
		
	}
	
	
	

}
