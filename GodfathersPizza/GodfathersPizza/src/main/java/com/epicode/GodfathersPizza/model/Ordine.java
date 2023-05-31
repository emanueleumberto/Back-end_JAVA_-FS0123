package com.epicode.GodfathersPizza.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Ordine {
	
	private int numeroOrdine;
	private Tavolo tavolo;
	private List<FoodItem> ordinato;
	private StatoOrdine stato;
	private int numeroCoperti;
	private double costoCoperto;
	private LocalDateTime oraAcquisizione;
	
	public Ordine(int numeroOrdine, Tavolo tavolo, int numeroCoperti, double costoCoperto) throws Exception {
		super();
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.tavolo.setOccupato(true);
		this.ordinato = new ArrayList<FoodItem>();
		this.stato = StatoOrdine.IN_CORSO;
		this.numeroCoperti = controlloCoperti(numeroCoperti);
		this.costoCoperto = costoCoperto;
		this.oraAcquisizione = LocalDateTime.now();
	}
	
	public int controlloCoperti(int coperti) throws Exception {
		if(this.tavolo.getNumeroCoperti() < coperti ) {
			throw new Exception("Numero di coperti errato!!!!");
		} else {
			return coperti;
		}
	}
	
	public Double getTotale() {
		double totale = 0;
		double costoCoperti = costoCoperto * numeroCoperti;
		for(FoodItem f : ordinato) {
			totale += f.getPrice();
		}
		return totale + costoCoperti;
	}

}
