package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadExample implements Runnable {
	
	private int[] arrElementi;
	private int indiceIniziale;
	private int numeroElementi;
	
	private Logger log = LoggerFactory.getLogger(ThreadExample.class);

	public ThreadExample(int[] arrElementi, int indiceIniziale, int numeroElementi) {
		super();
		this.arrElementi = arrElementi;
		this.indiceIniziale = indiceIniziale;
		this.numeroElementi = numeroElementi;
	}

	@Override
	public void run() {
		int sommaParziale = 0;
		for (int i = indiceIniziale; i < indiceIniziale + numeroElementi ; i++) {
			sommaParziale += arrElementi[i];
		}
		log.info("Somma Paraziale: " + sommaParziale);
		MainProject.listaRisultati.add(sommaParziale);
	}


}
