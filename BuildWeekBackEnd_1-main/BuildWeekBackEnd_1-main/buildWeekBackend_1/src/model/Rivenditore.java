package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import utils.TipoNegozio;


@Entity
@DiscriminatorValue("rivenditori")
public class Rivenditore extends Biglietteria {
	
	@Enumerated(EnumType.STRING)
	private TipoNegozio tipologia;
	
	
	public Rivenditore() {
		super();
	}


	public Rivenditore(TipoNegozio tipologia,Luogo luogo) {
		super(luogo);
		this.tipologia = tipologia;
	}


	public TipoNegozio getTipologia() {
		return tipologia;
	}


	public void setTipologia(TipoNegozio tipologia) {
		this.tipologia = tipologia;
	}


	@Override
	public String toString() {
		return "Rivenditore [" + super.toString() + " tipologia: " + tipologia + "]";
	}

	
}
