package com.epicode.esercizio1;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci una stringa: ");
		String str = sc.nextLine();
		if(stringaPariDispari(str)) {
			System.out.println("La stringa " + str + " è pari!!! " + str.length() );
		} else {
			System.out.println("La stringa " + str + " è dispari!!! " + str.length());
		}
		
		System.out.print("Inserisci anno: ");
		int anno = sc.nextInt();
		if(annoBisestile(anno)) {
			System.out.println("Anno " + anno + " è bisestile!!! " );
		} else {
			System.out.println("Anno " + anno + " non è bisestile!!! ");
		}
		
	}
	
	public static boolean stringaPariDispari(String str) {
		int numCaratteri = str.length();
		
		if(numCaratteri % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean annoBisestile(int anno) {
		if (anno % 4 != 0) {
            return false;
        } else if (anno % 400 == 0) {
            return true;
        } else if (anno % 100 == 0) {
            return false;
        } else {
            return true;
        }
	}

}
