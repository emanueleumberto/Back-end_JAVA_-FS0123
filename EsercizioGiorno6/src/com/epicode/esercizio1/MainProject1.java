package com.epicode.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject1 {
	
	private static Logger log = LoggerFactory.getLogger(MainProject1.class);
	private static Scanner sc = new Scanner(System.in);
	private static Set<String> setParole = new HashSet<String>();
	
	public static void main(String[] args) {
		inserisciParole();
	}

	public static void inserisciParole() {
		
		boolean continua = true;
		do {
			try {
				System.out.print("Inserisci il numero di parole da inserire oppure digita 0 per uscire: ");
				int numElementi = Integer.parseInt(sc.nextLine());
				
				if(numElementi == 0) {
					//log.error("0 - Numero di elementi errato!!!");
					continua = false;
				} else {
					for (int i = 0; i < numElementi; i++) {
						System.out.print("Inserisci una parola: ");
						String parola = sc.nextLine();
						
						// Controllo se la parola inserita da terminale è già presente nellamia collection
						//boolean rispParolaAgiunta = setParole.contains(parola);
						
						// .add(sc.nextLine()) mi restituisci true se la parola viene aggiunta nella collection
						// altrimenti viene restituito un false se la parola non viene aggiunta perchè duplicata
						boolean rispParolaAgiunta = setParole.add(parola);
						
						if(!rispParolaAgiunta) {
							System.out.println("Parola duplicata: " + parola);
						}
					}
					
					System.out.println("Numero di parole distinte: " + setParole.size());
					
					System.out.println("Elenco parole distinte: ");
					//setParole.forEach(p -> System.out.println(p));
					
					for (String parola : setParole) {
						System.out.println("  - " + parola);
					}
				}
			} catch (NumberFormatException e) {
				log.error("Non hai inserito un valore valido!!!");
				//e.printStackTrace();
			} finally {
				setParole.clear();
			}
		} while (continua);
			
		System.out.println("FINE");
		
	}

}
