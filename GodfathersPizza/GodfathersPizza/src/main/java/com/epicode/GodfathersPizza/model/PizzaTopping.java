package com.epicode.GodfathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PizzaTopping extends FoodItem {
	
	private Pizza pizza;

	public PizzaTopping(String name, double price, double calories) {
		super(name, price, calories);
	}

}
