package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject2 {
	
	private static Logger log = LoggerFactory.getLogger(MainProject2.class);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Inserisci il numero: ");
		int numElementi = Integer.parseInt(sc.nextLine());

		List<Integer> listaNumeri = listaRandom(numElementi);
		//listaNumeri.forEach(n -> System.out.println(n));
		List<Integer> listaSpeculare = listaSpeculare(listaNumeri);
		//listaSpeculare.forEach(n -> System.out.println(n));
		
		//stampaLista(listaNumeri, true);
		stampaLista(listaNumeri, false);
	}
	
	private static List<Integer> listaRandom(int n) {
		List<Integer> lista = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			lista.add(rand.nextInt(101));
		}
		return lista;
	}
	
	private static List<Integer> listaSpeculare(List<Integer> listaOriginale) {
		List<Integer> lista = new ArrayList<Integer>();
		
//		for (int i = 0; i < listaOriginale.size(); i++) {
//			lista.add(listaOriginale.get(i));
//		}
		
		lista.addAll(listaOriginale);
		
		for(int i = listaOriginale.size()-1; i >=0; i--) {
			lista.add(listaOriginale.get(i));
		}
		
		return lista;
	}

	private static void stampaLista(List<Integer> lista, boolean b) {
		System.out.println("***** STAMPA LISTA " + (b ? "PARI" : "DISPARI") +" *****");
		
		if(b) {
			for (int i = 0; i < lista.size(); i++) {
				if(i == 0 || i%2 == 0) {
					System.out.println("Posizione " + i + " - " + lista.get(i));
				}
			}
		} else {
			for (int i = 0; i < lista.size(); i++) {
				if(i%2 != 0) {
					System.out.println("Posizione " + i + " - " + lista.get(i));
				}
			}
		}
	}
}
