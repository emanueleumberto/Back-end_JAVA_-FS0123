package com.epicode.project.ExceptionHandler;

import java.util.Scanner;

public class MainProjectException {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Calcolatrice");
	
			operazione();
		
	}
	
	public static void operazione() {
		
		boolean end = false;
		do {
			try {
			System.out.println("Che tipo di operazione vuoi fare?");
			System.out.println("1 - Somma");
			System.out.println("2 - Sottrazione");
			System.out.println("3 - Moltiplicazione");
			System.out.println("4 - Divisione");
			System.out.println("5 - Fine");
			
		System.out.print("Fai una scelta: ");
		int scelta = Integer.parseInt(sc.nextLine());

		switch (scelta) {
		case 1: somma(); break;
		case 2: sottrazione(); break;
		case 3: moltiplicazione(); break;
		case 4: divisione(); break;
		case 5: end=true; break;
		default: System.out.println("Errore!!!");
		}
		} catch (NumberFormatException e) {
			System.out.println("Errore numero non valido!!");
		} catch (ArithmeticException e) {
			System.out.println("Errore di divisione per 0");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Errore!!!");
		} finally {
			System.out.println("Finally");
		}
		} while(!end);
	
		
	}
	
	public static void somma() {
		int num1 = chiediValore();
		int num2 = chiediValore();
		System.out.println("La somma tra " + num1 + " e " + num2 + " è " + (num1+num2)) ;
	}
	
	public static void sottrazione() {
		int num1 = chiediValore();
		int num2 = chiediValore();
		System.out.println("La sottrazione tra " + num1 + " e " + num2 + " è " + (num1-num2));
	}

	public static void moltiplicazione() throws MyException {
		int num1 = chiediValore();
		int num2 = chiediValore();
		if(num1 == 0 || num2 == 0) {
			throw new MyException("Moltiplicazione per 0 non accettata!!!");
		} 
		
		System.out.println("La moltiplicazione tra " + num1 + " e " + num2 + " è " + (num1*num2));
	}

	public static void divisione() {
		int num1 = chiediValore();
		int num2 = chiediValore();
		System.out.println("La divisione tra " + num1 + " e " + num2 + " è " + (num1/num2));
	}
	
	public static int chiediValore() {
		System.out.print("Inserisci un numero: ");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}

}
