package com.epicode.dependecyInjection;

public class Person {
	
	private String fullName;
	private IContinent address;
	private Phone phone;
	
	public Person(String fullName) {
		super();
		this.fullName = fullName;
		this.address = new EuropeanAddress("Roma", "Italia", "via abc");
		this.phone = new Phone("+39 123456789");
	}
	
	public Person(String fullName, IContinent address, Phone phone) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public IContinent getAddress() {
		return address;
	}

	public void setAddress(IContinent address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	
	

}
