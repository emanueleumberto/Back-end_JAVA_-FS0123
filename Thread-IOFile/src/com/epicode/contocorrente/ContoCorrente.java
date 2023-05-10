package com.epicode.contocorrente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {
	
	private double saldo;
	private String titolare;
	
	private Logger log = LoggerFactory.getLogger(ContoCorrente.class);

	public ContoCorrente(String titolare) {
		this.titolare = titolare;
		this.saldo = 0;
	}
	
	public double deposito(double importo) {
		System.out.println("Deposito di € " + importo + " da " + this.titolare);
		this.saldo += importo;
		return this.saldo;
	}
	
	public synchronized double prelievo(double importo) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(controlloPrelievo(importo)) {
			System.out.println("Prelievo di € " + importo + " da " + this.titolare);
			this.saldo -= importo;
		} else {
			System.out.println("ERRORE Prelievo di € " + importo + " da " + this.titolare);
		}
		return this.saldo;
	}
	
	public boolean controlloPrelievo(double importo) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.saldo >= importo;
	}

	@Override
	public String toString() {
		return "ContoCorrente [saldo=" + saldo + ", titolare=" + titolare + "]";
	}
	
	

}
