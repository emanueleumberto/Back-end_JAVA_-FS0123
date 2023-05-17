package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cognome;
	private int eta;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Citta citta;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Smartphone smartphone;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CorsiOnline> listaCorsi;

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, int eta, Citta citta, Smartphone smartphone) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.citta = citta;
		this.smartphone = smartphone;
		this.listaCorsi = new ArrayList<CorsiOnline>();
		
	}
	
	public void addCorso(CorsiOnline co) {
		listaCorsi.add(co);
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public Smartphone getSmartphone() {
		return smartphone;
	}

	public void setSmartphone(Smartphone smartphone) {
		this.smartphone = smartphone;
	}

	public List<CorsiOnline> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(List<CorsiOnline> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", citta=" + citta + ", smartphone="
				+ smartphone + "]";
	}

	
}
