package com.epicode.GodfathersPizza.model;

import lombok.Data;

@Data
public class Tavolo {
	
	private int numeroTavolo;
	private int numeroCoperti;
	private boolean occupato;
	
	public Tavolo(int numeroTavolo, int numeroCoperti) {
		super();
		this.numeroTavolo = numeroTavolo;
		this.numeroCoperti = numeroCoperti;
		this.occupato = false;
	}

}
