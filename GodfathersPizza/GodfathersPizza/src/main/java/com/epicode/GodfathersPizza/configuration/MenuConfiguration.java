package com.epicode.GodfathersPizza.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.GodfathersPizza.model.Menu;
import com.epicode.GodfathersPizza.model.Pizza;
import com.epicode.GodfathersPizza.model.PizzaFamilySize;
import com.epicode.GodfathersPizza.model.PizzaHawaiian;
import com.epicode.GodfathersPizza.model.PizzaMargherita;
import com.epicode.GodfathersPizza.model.PizzaSalami;

@Configuration
public class MenuConfiguration {
	
	@Bean
	public Menu menu() {
		Menu m = new Menu();
		
//		List<Pizza> listaPizze = m.getMenuPizza();
//		PizzaMargherita pm = pizzaMargherita();
//		listaPizze.add(pm);
		
		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(pizzaHawaiian());
		m.getMenuPizza().add(pizzaSalami());
		m.getMenuPizza().add(pizzaFamilySize(pizzaMargherita()));
		
		return m;
	}
	
	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}
	
	@Bean
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}
	
	@Bean
	public PizzaFamilySize pizzaFamilySize(Pizza p) {
		return new PizzaFamilySize(p);
	}

}
