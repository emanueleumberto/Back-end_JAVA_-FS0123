package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

	public static void main (String[] args) {
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		
		// Soluzione Esercizio 2
		
		int num1 = 10;
		int num2 = 15;
		String str = "N";
		String[] strArr = {"A", "B", "C", "D", "E"};
		
		int mol = moltiplica(num1, num2);
		System.out.println("Il risultato della moltiplicazione tra " + num1 + " e " + num2 + " è " + mol);
		String con = concatena(str, num1);
		System.out.println("Il risultato della concatenazione tra " + str + " e " + num1 + " è " + con);
		String[] returnArr = inserisciInArray(strArr, str);
		System.out.println("La lunghezza del nuovo array è: " + returnArr.length);
		for (int i = 0; i < returnArr.length; i++) {
			System.out.println(i + ": " + returnArr[i]);			
		}
		
		// Soluzione Esercizio 3
		Scanner sc = new Scanner(System.in);
		String[] arrStr = new String[3];
		int i = 0;
		while(i < arrStr.length) {
				System.out.print("Inserisci una stringa: ");
				arrStr[i] = sc.nextLine();
				i++;
		}
		
		stampaStringhe(arrStr);
		
	}
	
	public static int moltiplica(int num1, int num2) {
		return num1 * num2;
	}
	
	public static String concatena(String str, int num) {
		return str + num;
	}
	
	public static String[] inserisciInArray(String[] arr, String str) {
//		String[] result = new String[6];
//		result[0] = arr[0];
//		result[1] = arr[1];
//		result[2] = str;
//		result[3] = arr[2];
//		result[4] = arr[3];
//		result[5] = arr[4];
		
		String[] result = {arr[0], arr[1], str, arr[2], arr[3], arr[4]};
		
		return result;
	}
	
	public static void stampaStringhe(String[] arr) {	
		System.out.println(arr.length);
		System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]);
		System.out.println(arr[2] + ", " + arr[1] + ", " + arr[0]);
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		for (int i = arr.length; i >= 0; i--) {
//			System.out.println(arr[i]);
//		}
	}

	public static double perimetroRettangolo(double num1, double num2) {
		return num1*2+num2*2;
	}
	
	public static int pariDispari(int num1) {
		return num1 % 2;
	}
	
	public static double areaTriangolo(double num1, double num2, double num3) {
		return 1;
	}
}


