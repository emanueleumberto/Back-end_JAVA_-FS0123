package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import utils.DurataAbb;

@Entity
@DiscriminatorValue("abbonamenti")
public class Abbonamento extends TitoloViaggio {
	
	@ManyToOne
	private Utente titolare;

	
	public Abbonamento() {
		super();
	}

	public Abbonamento(Utente titolare) {
		super();
		this.titolare = titolare;
	}
	
	public Abbonamento(DurataAbb durata, Biglietteria luogoEmissione, Utente titolare) {
		super(durata, luogoEmissione);
		this.titolare = titolare;
	}

	public Utente getTitolare() {
		return titolare;
	}

	public void setTitolare(Utente titolare) {
		this.titolare = titolare;
	}

	@Override
	public String toString() {
		return "Abbonamento [ "+ super.toString() + "titolare=" + titolare + "]";
	}
	
	
}
