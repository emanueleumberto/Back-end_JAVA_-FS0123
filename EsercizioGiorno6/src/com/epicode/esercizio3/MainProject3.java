package com.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject3 {
	
	private static Logger log = LoggerFactory.getLogger(MainProject3.class);
	private static Map<String, String> rubrica = new HashMap<String, String>();

	public static void main(String[] args)  {

		try {
			aggiungiContatto("Mario","123456");
			aggiungiContatto("Giuseppe","987654");
			aggiungiContatto("Francesca", "654392");
			
			System.out.println(ricercaPersona("987654"));
			System.out.println(ricercaNumero("Francesca"));
			
			rimuoviContatto("Giuseppe");
			
			stampaRubrica();
			
		} catch (Exception e) {
			log.error("ERRORE " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void aggiungiContatto(String nome, String telefono) throws Exception {
		if(rubrica.containsKey(nome)) {
			throw new Exception("Contatto già presente in rubrica!!!");
		} else {
			rubrica.put(nome, telefono);
		} 
	}
	
	private static void rimuoviContatto(String nome) {
		rubrica.remove(nome);
	}
	
	private static String ricercaPersona(String telefono) {
		for (String nome : rubrica.keySet()) {
			if(rubrica.get(nome).equals(telefono)) {
				return nome;
			}
		}
		return null;
	}
	
	private static String ricercaNumero(String nome) {
		return rubrica.get(nome);
	}
	
	private static void stampaRubrica() {
		System.out.println("***** STAMPA RUBRICA *****");
		Set<String> key = rubrica.keySet();
		for (String nome : key) {
			System.out.println("  - " + nome + " num." + rubrica.get(nome));;
		}
	}

}
