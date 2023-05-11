package com.epicode.lambda;

import java.util.ArrayList;
import java.util.List;

public class MainProject {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		
		lista.add("Primo Elemento");
		lista.add("Secondo Elemento");
		lista.add("Terzo Elemento");
		
		// () -> corpo della funzione
		// (parametro 1, parametro2) -> corpo della funzione
		// parametro 1 -> corpo della funzione
		
//		for (String s : lista) {
//			System.out.println(s);
//		}
		
//		lista.forEach(e -> System.out.println(e));
		
		
		//Soluzione 1
		ClasseConcreta c = new ClasseConcreta();
		TestMessage t = new TestMessage();
		stampaMessaggio(c);
		stampaMessaggio(t);
		
		//Soluzione 2
		stampaMessaggio(new ClasseConcreta());
		
		//Soluzione 3
		stampaMessaggio(new IMessage() {
			@Override
			public String getMessage() {
				return "Messaggio Classe Anonima!!!!";
			}
		});
		
		//Soluzione 4 Solo se le interfacce definiscono un metodo
		stampaMessaggio(()-> "Messaggio Labda Anonima!!!!");
		
		
		MioThread t1 = new MioThread();
		Thread th1 = new Thread(t1);
		
		Thread th2 = new Thread(new MioThread());
		
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread Anonimo!!!");
			}
		});
		
		Thread th4 = new Thread(() -> {
			System.out.println("Thread Lambda!!!");
		});
		
		th1.start();
		th2.start();
		th3.start();	
		th4.start();
	}
	
	public static void stampaMessaggio(IMessage o) {
		System.out.println(o.getMessage());
	}
	
	
}
