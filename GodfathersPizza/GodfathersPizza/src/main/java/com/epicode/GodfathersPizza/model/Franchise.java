package com.epicode.GodfathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Franchise {
	
	private String name;
	private double price;
	
	public String getMenuItemLine() {
		return this.name + " - price: " + this.price;
	}

}
