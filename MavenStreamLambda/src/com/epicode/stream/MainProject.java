package com.epicode.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProject {
	
	static List<Contatto> listaContatti = new ArrayList<Contatto>();

	public static void main(String[] args) {
		
		// Stream di Collection
		Collection<String> c1 = new ArrayList<String>();
		List<String> c2 = new ArrayList<String>();
		List<String> c3 = Arrays.asList("epicode", "test", "abc");
		
		// Stream di Array
		String[] arrStr = {"epicode", "test", "abc" };
		Stream<String> streamArr = Arrays.stream(arrStr);
		
		// Stream tramite builder
		Stream<String> streamBuild =  Stream.<String>builder()
														.add("test")
														.add("epicode")
														.add("abc").build();
		
		
		
		// Operazioni su Stream
		
		List<String> lista = new ArrayList<String>();
		lista.add("Angular");
		lista.add("React");
		lista.add("Java");
		lista.add("C#");
		lista.add("Javascript");
		lista.add("Typescript");
		
		lista.forEach(e -> System.out.println(e));
		
		// [Angular! Javascript! Typescript!]
		Stream<String> streamFiltrato = lista.stream()
			.filter(e -> e.length() >= 7)
			.map(e -> e + "!")
			.sorted();
		
		List<String> listaFiltrata = streamFiltrato.collect(Collectors.toList());
		
		Set<String> setFiltrato = lista.stream()
				.filter(e -> e.length() >= 7)
				.map(e -> e + "!")
				.sorted()
				.collect(Collectors.toSet());
		
		String s = lista.stream()
				.filter(e -> e.length() >= 7)
				.map(e -> e + "!")
				.sorted()
				.reduce("", (acc, val) -> acc + val + "#");
		
		// Javascript -> [5, 7, 2, 6].reduce((acc, val) => acc + val, 0)
		// acc = 0;
		// acc = 5;
		// acc = 12;
		// acc = 14;
		// acc = 20;
		// 20
		
		System.out.println(s);
		
		
		// Esempio Gestione contatti con e senza Stream
		listaContatti.add(new Contatto("Mario", "Rossi", "Roma"));
		listaContatti.add(new Contatto("Giuseppe", "Verdi", "Milano"));
		listaContatti.add(new Contatto("Antonio", "Gialli", "Verona"));
		listaContatti.add(new Contatto("Francesca", "Neri", "Roma"));
		listaContatti.add(new Contatto("Sara", "Viola", "Roma"));
		
		List<Contatto> listaFiltrata1 = filtraContatti(listaContatti, "Roma");
		listaFiltrata1.forEach(e -> System.out.println(e));
		List<Contatto> listaFiltrata2 = filtraContattiStream(listaContatti, "Roma");
		listaFiltrata2.forEach(e -> System.out.println(e));
	}
	
	public static List<Contatto> filtraContatti(List<Contatto> lista, String citta) {
		List<Contatto> listaFiltrata = new ArrayList<Contatto>();
			for (Contatto contatto : lista) {
				if(contatto.citta.equals(citta)) {
					listaFiltrata.add(contatto);
				}
			}
		return listaFiltrata;
	}
	
	public static List<Contatto> filtraContattiStream(List<Contatto> lista, String citta) {
		return lista.stream()
				.filter(c -> c.citta.equals(citta))
				.collect(Collectors.toList());
	}

}
