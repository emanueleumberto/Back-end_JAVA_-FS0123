package com.epicode.GodfathersPizza.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Menu {
	
	private List<Pizza> menuPizza = new ArrayList<Pizza>();
	private List<Drink> menuDrink = new ArrayList<Drink>();
	private List<PizzaTopping> menuTopping = new ArrayList<PizzaTopping>();
	private List<Gift> menuGift = new ArrayList<Gift>();

}
