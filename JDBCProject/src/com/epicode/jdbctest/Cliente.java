package com.epicode.jdbctest;

import java.time.LocalDate;

public class Cliente {
	
	private Integer numero_cliente; 
	private String nome; 
	private String cognome; 
	private LocalDate data_nascita; 
	private String regione_residenza;
	
	public Cliente(String nome, String cognome, LocalDate data_nascita, String regione_residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
	}

	public Cliente(Integer numero_cliente, String nome, String cognome, LocalDate data_nascita, String regione_residenza) {
		super();
		this.numero_cliente = numero_cliente;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
	}

	public Integer getNumero_cliente() {
		return numero_cliente;
	}

	public void setNumero_cliente(Integer numero_cliente) {
		this.numero_cliente = numero_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getRegione_residenza() {
		return regione_residenza;
	}

	public void setRegione_residenza(String regione_residenza) {
		this.regione_residenza = regione_residenza;
	}

	@Override
	public String toString() {
		return "Cliente [numero_cliente=" + numero_cliente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + ", regione_residenza=" + regione_residenza + "]";
	}

}
