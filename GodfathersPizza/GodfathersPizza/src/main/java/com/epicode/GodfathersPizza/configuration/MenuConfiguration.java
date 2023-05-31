package com.epicode.GodfathersPizza.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.GodfathersPizza.model.Drink;
import com.epicode.GodfathersPizza.model.DrinkLemonade;
import com.epicode.GodfathersPizza.model.DrinkWater;
import com.epicode.GodfathersPizza.model.FranchiseMug;
import com.epicode.GodfathersPizza.model.FranchiseShirt;
import com.epicode.GodfathersPizza.model.Menu;
import com.epicode.GodfathersPizza.model.Pizza;
import com.epicode.GodfathersPizza.model.PizzaFamilySize;
import com.epicode.GodfathersPizza.model.PizzaHawaiian;
import com.epicode.GodfathersPizza.model.PizzaMargherita;
import com.epicode.GodfathersPizza.model.PizzaSalami;
import com.epicode.GodfathersPizza.model.ToppingCheese;
import com.epicode.GodfathersPizza.model.ToppingOnions;
import com.epicode.GodfathersPizza.model.ToppingSalami;

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
		m.getMenuPizza().add(pizzaFamilySize());
		
		m.getMenuDrink().add(drinkLemonade());
		m.getMenuDrink().add(drinkWater());
		
		m.getMenuTopping().add(toppingCheese());
		m.getMenuTopping().add(toppingOnions());
		m.getMenuTopping().add(toppingSalami());
		
		m.getMenuFranchise().add(franchiseMug());
		m.getMenuFranchise().add(franchiseShirt());
		
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
	@Scope("prototype")
	public PizzaFamilySize pizzaFamilySizePizza(Pizza p) {
		return new PizzaFamilySize(p);
	}
	
	@Bean
	public PizzaFamilySize pizzaFamilySize() {
		return new PizzaFamilySize();
	}
	
	@Bean
	public Drink drinkLemonade() {
		return new DrinkLemonade();
	}
	
	@Bean
	public Drink drinkWater() {
		return new DrinkWater();
	}
	
	@Bean
	public ToppingCheese toppingCheese() {
		return new ToppingCheese();
	}
	
	@Bean
	public ToppingOnions toppingOnions() {
		return new ToppingOnions();
	}
	
	@Bean
	public ToppingSalami toppingSalami() {
		return new ToppingSalami();
	}
	
	@Bean
	public FranchiseMug franchiseMug() {
		return new FranchiseMug();
	}
	
	@Bean
	public FranchiseShirt franchiseShirt() {
		return new FranchiseShirt();
	}

}
