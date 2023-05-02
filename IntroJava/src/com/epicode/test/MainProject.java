package com.epicode.test;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {

		boolean b = true;
		char c = 'f';
		int i = 25;
		//short sh = i; ERRORE!!!
		long l = i;
		double d = 25.3;
		// float 32bit -> double 64bit
		float f = 25.3f;
		
		//String str = new String();
		String s = "Ciao";
		s = "abc";
		final String ABC = "Costante!";
		//ABC = "zdpogfjò"; ERRORE
		
		//System.out.println("Ciao a tutti");
		
		int arr[] = new int[10];
		arr[0] = 25;
		arr[8] = 9;
		
		//System.out.println(arr.length);
		
		char sett[] = {'L', 'M', 'M'};
		
		//System.out.println(sett.length);
		
		
		int num1 = 25;
		int num2 = 10;
		long lnum1 = num1;
		short snum1 = (short) num1;
		
		double resultErr = num1 / num2; // Errore
		//System.out.println(resultErr);
		double result = (double) num1 / (double)num2;
		//System.out.println(result);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci il nome:");
		String nome = sc.nextLine();
		System.out.println("Ciao " + nome);
		
		System.out.print("Inserisci numero1:");
		int n1 = sc.nextInt();
		System.out.print("Inserisci numero2:");
		int n2 = sc.nextInt();
		test(n1, n2);
	}
	
	public static void test(int num1, int num2) {
		int res = num1+num2;
		System.out.println("il risultato della somma è: " + res);
	}

}
