package com.epicode.GodfathersPizza.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.configuration.OrdineConfiguration;
import com.epicode.GodfathersPizza.model.Ordine;
import com.epicode.GodfathersPizza.model.Tavolo;

@Component
public class OrdineRunner implements CommandLineRunner {
	
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrdineConfiguration.class);
	Map<Integer, Tavolo> listaTavoli = new HashMap<Integer, Tavolo>();

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run OrdineRunner...");
		
		configTavoloWith_Bean();
		configOrdiniWith_Bean();
		
		appContext.close();
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
		
		System.out.println(ordine1);
		
		//appContext.close();
	}
}
