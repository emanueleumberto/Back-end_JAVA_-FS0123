package com.epicode.esercizio3;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		String str;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Inserisci una stringa: ");
			str = sc.nextLine();
			
			
			if(!str.equals(":q")) {
				String newStr = "";
				
				String[] s = str.split("");
				
				for (int i = 0; i < s.length; i++) {
					newStr += s[i] + ",";
				}
				System.out.println(newStr);
			}
				
				
		} while (!str.equals(":q"));

	}

}
