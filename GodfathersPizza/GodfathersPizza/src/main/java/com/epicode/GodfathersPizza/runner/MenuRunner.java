package com.epicode.GodfathersPizza.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.configuration.MenuConfiguration;
import com.epicode.GodfathersPizza.model.Menu;

@Component
public class MenuRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run MenuRunner...");
		
		configMenuWith_Bean();
		
	}
	
	public static void configMenuWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		System.out.println("******* Menu *******");
		System.out.println("PIZZAS");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println("TOPPINGS");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuItemLine()));
		System.out.println("DRINKS");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuItemLine()));
		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(o -> System.out.println(o.getMenuItemLine()));
		
		// Chiudo il Context
		appContext.close();
	}

}
