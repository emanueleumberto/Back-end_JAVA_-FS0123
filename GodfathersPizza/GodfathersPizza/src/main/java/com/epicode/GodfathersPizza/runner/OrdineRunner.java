package com.epicode.GodfathersPizza.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.configuration.MenuConfiguration;
import com.epicode.GodfathersPizza.configuration.OrdineConfiguration;
import com.epicode.GodfathersPizza.model.Drink;
import com.epicode.GodfathersPizza.model.Ordine;
import com.epicode.GodfathersPizza.model.Pizza;
import com.epicode.GodfathersPizza.model.PizzaTopping;
import com.epicode.GodfathersPizza.model.Tavolo;

@Component
public class OrdineRunner implements CommandLineRunner {
	
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrdineConfiguration.class);
	AnnotationConfigApplicationContext appMenuContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
	Map<Integer, Tavolo> listaTavoli = new HashMap<Integer, Tavolo>();
	Map<Integer, Ordine> listaOrdini = new HashMap<Integer, Ordine>();

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run OrdineRunner...");
		
		configTavoloWith_Bean();
		configOrdiniWith_Bean();

		for(int i=1; i<=listaOrdini.size(); i++) {
			System.out.println("Ordine n. " + listaOrdini.get(i).getNumeroOrdine());
			listaOrdini.get(i).getOrdinato().forEach(f -> System.out.println(f.getName() + " $" + f.getPrice()));
			System.out.println("Totale: " + listaOrdini.get(i).getTotale());
		}
		
		appContext.close();
		appMenuContext.close();
	}

	public void configTavoloWith_Bean() {
		//AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrdineConfiguration.class);
	
		System.out.println("******* Tavoli *******");
		
		// Recupero il Bean Tavolo
		Tavolo tavolo1 = (Tavolo) appContext.getBean("tavolo", 1, 4);
		Tavolo tavolo2 = (Tavolo) appContext.getBean("tavolo", 2, 2);
		Tavolo tavolo3 = (Tavolo) appContext.getBean("tavolo", 3, 6);
		
		listaTavoli.put(tavolo1.getNumeroTavolo(), tavolo1);
		listaTavoli.put(tavolo2.getNumeroTavolo(), tavolo2);
		listaTavoli.put(tavolo3.getNumeroTavolo(), tavolo3);
		
		System.out.println(listaTavoli.get(1));
		System.out.println(listaTavoli.get(2));
		System.out.println(listaTavoli.get(3));
		
//		System.out.println(tavolo1);
//		System.out.println(tavolo2);
//		System.out.println(tavolo3);
		
		//appContext.close();
	}

	public void configOrdiniWith_Bean() {
		//AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrdineConfiguration.class);
		
		System.out.println("******* Ordini *******");
		
		// Recupero il Bean Ordine
		Ordine ordine1 = (Ordine) appContext.getBean("ordine",1, listaTavoli.get(1), 2);
		
		Pizza margherita = (Pizza) appMenuContext.getBean("pizzaMargherita");
		Pizza salami = (Pizza) appMenuContext.getBean("pizzaSalami");
		
		PizzaTopping toppingOnions = (PizzaTopping) appMenuContext.getBean("toppingOnions");
		toppingOnions.setPizza(margherita);
		Drink lemonade = (Drink) appMenuContext.getBean("drinkLemonade");
		Drink water = (Drink) appMenuContext.getBean("drinkWater");
		
		ordine1.getOrdinato().add(margherita);
		ordine1.getOrdinato().add(toppingOnions);
		ordine1.getOrdinato().add(salami);
		ordine1.getOrdinato().add(lemonade);
		ordine1.getOrdinato().add(water);
		
		listaOrdini.put(ordine1.getNumeroOrdine(), ordine1);
		//System.out.println(ordine1);
		
		// Recupero il Bean Ordine
		Ordine ordine2 = (Ordine) appContext.getBean("ordine",2, listaTavoli.get(3), 3);
		
		ordine2.getOrdinato().add((Pizza) appMenuContext.getBean("pizzaMargherita"));
		ordine2.getOrdinato().add((Pizza) appMenuContext.getBean("pizzaHawaiian"));
		ordine2.getOrdinato().add((Pizza) appMenuContext.getBean("pizzaFamilySizePizza", (Pizza) appMenuContext.getBean("pizzaMargherita")));
		ordine2.getOrdinato().add((Drink) appMenuContext.getBean("drinkWater"));
		ordine2.getOrdinato().add((Drink) appMenuContext.getBean("drinkWater"));
		ordine2.getOrdinato().add((Drink) appMenuContext.getBean("drinkWater"));
		
		listaOrdini.put(ordine2.getNumeroOrdine(), ordine2);
		
		//appContext.close();
	}
}
