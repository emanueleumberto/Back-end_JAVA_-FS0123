package com.epicode.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {
	
	private static List<Order> listaOrdini = new ArrayList<Order>();
	private static List<Product> listaProdotti = new ArrayList<Product>();

	public static void main(String[] args) {

		Product p1 = new Product(1L, "Il Signore degli anelli", "Books", 18.0);
		Product p2 = new Product(2L, "Pannolini", "Baby", 5.0);
		Product p3 = new Product(3L, "Jeans", "Boys", 81.0);
		Product p4 = new Product(4L, "Batman", "Books", 14.0);
		Product p5 = new Product(5L, "T-shirt", "Boys", 49.0);
		
		Customer c1 = new Customer(1L, "Mario Rossi", 1);
		Customer c2 = new Customer(2L, "Giuseppe Verdi", 2);
		Customer c3 = new Customer(3L, "Francesca Neri", 3);
		
		
		listaProdotti.add(p1);
		listaProdotti.add(p2);
		listaProdotti.add(p3);
		listaProdotti.add(p4);
		listaProdotti.add(p5);
				
		listaOrdini.add(new Order(1L, Arrays.asList(p2, p3) , c1));
		listaOrdini.add(new Order(2L, Arrays.asList(p1, p3, p5), c2));
		listaOrdini.add(new Order(3L, Arrays.asList(p1, p2, p3, p4, p5), c3));
	
		System.out.println("******** Lista Prodotti *********");
		listaProdotti.forEach(p -> System.out.println(p));
		
		// Esercizio #1
		// Ottenere una lista di prodotti che appartengono alla 
		// categoria «Books» ed hanno un prezzo > 100
		
		System.out.println("******** Lista Prodotti Books > 15 *********");
		List<Product> listaProdottiFiltrati =  getProdotti("Books", 15.0);
		listaProdottiFiltrati.forEach(p -> System.out.println(p));
		
		//Esercizio #2
		//Ottenere una lista di ordini con prodotti che appartengono 
		//alla categoria «Baby»
		System.out.println("******** Lista Ordini Baby *********");
		List<Order> listaOrdiniFiltrati = getOrder("Baby");
		listaOrdiniFiltrati.forEach(o -> System.out.println(o));

		//Esercizio #3
		//Ottenere una lista di prodotti che appartengono alla 
		//categoria «Boys» ed applicare 10% di sconto al loro prezzo
		System.out.println("******** Lista Prodotti Boys scontati 10% *********");
		List<Product> listaProdottiScontati = getProdottiScontati("Boys", 0.9);
		listaProdottiScontati.forEach(p -> System.out.println(p));
		
		//Esercizio #4
		//Ottenere una lista di prodotti ordinati da clienti 
		//di livello (tier) 2 tra l’01-Feb-2021 e l’01-Apr-2021
		System.out.println("******** Lista Prodotti Livello 2 *********");
		List<Product> listaProdottiTier = getProdottiTier(2, LocalDate.of(2023, 05, 10), LocalDate.of(2023, 05, 12));
		listaProdottiTier.forEach(p -> System.out.println(p));
		
	}
	
	public static List<Product> getProdotti(String categoria, Double prezzo) {	
		return listaProdotti.stream()
					.filter(p -> p.getCategory().equals(categoria))
					.filter(p -> p.getPrice() > prezzo)
					.collect(Collectors.toList());
	}
	
	public static List<Order> getOrder(String categoria) {
		return listaOrdini.stream()
						.filter(o -> o.getProducts()
										.stream()
										.anyMatch(p -> p.getCategory().equalsIgnoreCase(categoria))
								)
						.collect(Collectors.toList());
	}
	
	public static List<Product> getProdottiScontati(String categoria, Double sconto) {
		return listaProdotti.stream()
					.filter(p -> p.getCategory().equals(categoria))
					.map(p -> {
						Product pr = p;
						pr.setPrice(pr.getPrice() * sconto);
						return pr;
					})
					.collect(Collectors.toList());
	}
	
	public static List<Product> getProdottiTier(Integer tier, LocalDate dataStart, LocalDate dataEnd) {
		return listaOrdini.stream()
				.filter(o -> o.getCustomer().getTier() == tier)
				.filter(o -> o.getOrderDate().compareTo(dataStart) >= 0)
				.filter(o -> o.getOrderDate().compareTo(dataEnd) <= 0)
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());
	}

}
