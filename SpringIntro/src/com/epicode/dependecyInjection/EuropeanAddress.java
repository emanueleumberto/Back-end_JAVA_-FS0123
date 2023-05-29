package com.epicode.dependecyInjection;

public class EuropeanAddress implements IContinent{
	
	private String city;
	private String state;
	private String street;
	
	public EuropeanAddress(String city, String state, String street) {
		super();
		this.city = city;
		this.state = state;
		this.street = street;
	}
	
	

}
