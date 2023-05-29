package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import utils.DurataAbb;

@Entity
@DiscriminatorValue("biglietti")
public class Biglietto extends TitoloViaggio {
	
//	@Column(name= "durata_giornaliera")	private  DurataAbb durata = DurataAbb.GIORNALIERO;

	
	public Biglietto() {
		super();
	
	}
	public Biglietto(Biglietteria luogoEmissione) {
		super(LocalDate.now(), DurataAbb.GIORNALIERO, luogoEmissione);
	}
	
	public Biglietto(LocalDate dataEmissione,
			Biglietteria luogoEmissione) {
		super(dataEmissione, DurataAbb.GIORNALIERO, luogoEmissione);
	}
	


//	@Override
//	public String toString() {
//		return "Biglietto [durataGiornaliera=" + durataGiornaliera + "]";
//	}
	


	

	

	
}
