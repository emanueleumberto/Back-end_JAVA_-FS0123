package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import utils.DurataAbb;

@Entity
@Table(name="titoli_viaggio")
@DiscriminatorColumn(name="tipo_biglietto", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class TitoloViaggio {
	
	@Id
	@SequenceGenerator(name = "codice_biglietto", sequenceName = "codice_biglietto", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codice_biglietto")
	private Integer codice;
	
	@Column(name = "data_emissione", nullable = false)
	private LocalDate dataEmissione;
	
	@Column(name = "data_scadenza", nullable = false)
	private LocalDate dataScadenza;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private DurataAbb durata;
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "biglietteria_emissione")
	private Biglietteria biglietteriaEmissione;

	
	
	public TitoloViaggio() {
		super();
	}
	
	public TitoloViaggio(DurataAbb durata, Biglietteria luogoEmissione) {
		super();
		this.dataEmissione = LocalDate.now();
		this.durata = durata;
		this.dataScadenza = 
				this.durata.equals(DurataAbb.GIORNALIERO) ? LocalDate.now().plusDays(1) 
				: this.durata.equals(DurataAbb.SETTIMANALI) ? LocalDate.now().plusDays(7) 
				: LocalDate.now().plusMonths(1);
		this.biglietteriaEmissione = luogoEmissione;
	}

	public TitoloViaggio(LocalDate dataEmissione, DurataAbb durata, Biglietteria luogoEmissione) {
		super();
		this.dataEmissione = dataEmissione;
		this.durata = durata;
		this.dataScadenza = 
				this.durata.equals(DurataAbb.GIORNALIERO) ? this.dataEmissione.plusDays(1) 
				: this.durata.equals(DurataAbb.SETTIMANALI) ? this.dataEmissione.plusDays(7) 
				: this.dataEmissione.plusMonths(1);
		this.biglietteriaEmissione = luogoEmissione;
	}

	public Integer getCodice() {
		return codice;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public DurataAbb getDurata() {
		return durata;
	}

	public void setDurata(DurataAbb durata) {
		this.durata = durata;
	}

	public Biglietteria getLuogoEmissione() {
		return biglietteriaEmissione;
	}

	public void setLuogoEmissione(Biglietteria luogoEmissione) {
		this.biglietteriaEmissione = luogoEmissione;
	}
	
	public boolean isValido() {
		boolean validita = (this.dataScadenza.compareTo(LocalDate.now()) > 0) ? true : false;
		return validita;
	}

	@Override
	public String toString() {
		return "TitoloViaggio [codice=" + codice + ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza
				+ ", durata=" + durata + ", luogoEmissione=" + biglietteriaEmissione + "]";
	}
	
	
}
