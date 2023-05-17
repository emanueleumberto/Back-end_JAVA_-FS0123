package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "corsi_online")
public class CorsiOnline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int ore;
	
	@ManyToMany(mappedBy = "listaCorsi")
	private List<Utente> partecipanti;

	public CorsiOnline() {
		super();
	}

	public CorsiOnline(String name, int ore) {
		super();
		this.name = name;
		this.ore = ore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	public List<Utente> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(List<Utente> partecipanti) {
		this.partecipanti = partecipanti;
	}

	@Override
	public String toString() {
		return "CorsiOnline [id=" + id + ", name=" + name + ", ore=" + ore + ", partecipanti=" + partecipanti.size() + "]";
	}

}
