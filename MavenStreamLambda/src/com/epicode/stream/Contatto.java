package com.epicode.stream;

public class Contatto {
	
	String nome;
	String cognome;
	String citta;
	
	public Contatto(String nome, String cognome, String citta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", citta=" + citta + "]";
	}
	
	

}
