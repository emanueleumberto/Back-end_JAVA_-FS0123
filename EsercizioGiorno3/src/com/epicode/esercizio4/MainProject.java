package com.epicode.esercizio4;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci numero intero: ");
		int num = sc.nextInt();
		
		for (int i = num; i >= 0; i--) {
			System.out.println(i);
		}

	}

}
