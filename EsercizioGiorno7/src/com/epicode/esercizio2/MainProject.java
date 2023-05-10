package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static int[] arrayElementi;
	static List<Integer> listaRisultati = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(MainProject.class);
		arrayElementi = inizializzaArray(3000);
		
		Thread t1 = new Thread(new ThreadExample(arrayElementi, 0, 1000));
		Thread t2 = new Thread(new ThreadExample(arrayElementi, 1000, 1000));
		Thread t3 = new Thread(new ThreadExample(arrayElementi, 2000, 1000));
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer sommatotale = 0;
		
		for (Integer v : listaRisultati) {
			sommatotale += v;
		}
		
		log.info("Somma Totale di ogni Thread: " + sommatotale);

	}
	
	private static int[] inizializzaArray(int size) {
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(100);
		}
		return arr;
	}


}
