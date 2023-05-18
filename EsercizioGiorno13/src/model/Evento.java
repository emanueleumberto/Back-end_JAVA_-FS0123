package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import Enumerations.TipoEvento;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "findAllEventi", query = "SELECT ev FROM Evento ev")
public class Evento {
	
	@Id
	@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private LocalDate dataEvento;
	
	private String descrizione;
		
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private Integer numeroMassimoPartecipanti;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
	private Set<Partecipazione> setPartecipazioni;
	
	@ManyToOne
	private Location location;
	
	public Evento() {
		super();
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Set<Partecipazione> setPartecipazioni, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.setPartecipazioni = setPartecipazioni;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Integer getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Set<Partecipazione> getSetPartecipazioni() {
		return setPartecipazioni;
	}

	public void setSetPartecipazioni(Set<Partecipazione> setPartecipazioni) {
		this.setPartecipazioni = setPartecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti
				+ ", setPartecipazioni=" + setPartecipazioni + ", location=" + location + "]";
	}

}
