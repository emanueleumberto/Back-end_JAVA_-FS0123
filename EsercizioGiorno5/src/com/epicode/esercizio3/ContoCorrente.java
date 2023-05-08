package com.epicode.esercizio3;

public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) throws BancaException {
		try {
			if (nMovimenti < maxMovimenti)
				saldo = saldo - x;
				if(saldo < 0) {
					throw new BancaException("Conto in rosso!!!");
				}
			else
				saldo = saldo - x - 0.50;
		}  finally {
			nMovimenti++;
		}
	}

	double restituisciSaldo() {
		return saldo;
	}
}
