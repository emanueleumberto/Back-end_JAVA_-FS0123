package com.epicode.GodfathersPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.GodfathersPizza.configuration.MenuConfiguration;
import com.epicode.GodfathersPizza.model.Menu;

@SpringBootApplication
public class GodfathersPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
		
		configWith_Bean();
	}
	
	public static void configWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
		
		// Chiudo il Context
		appContext.close();
	}

}
