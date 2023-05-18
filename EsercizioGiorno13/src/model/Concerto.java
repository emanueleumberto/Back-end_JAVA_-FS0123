package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import Enumerations.GenereConcerto;

@Entity
@NamedQuery(name = "concertiInStreaming", query= "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query= "SELECT c FROM Concerto c WHERE c.genere IN :listaGenere")
public class Concerto extends Evento {
	
	@Enumerated(EnumType.STRING)
	private GenereConcerto genere;
	private Boolean	inStreaming;
	
	public GenereConcerto getGenere() {
		return genere;
	}
	public void setGenere(GenereConcerto genere) {
		this.genere = genere;
	}
	public Boolean getInStreaming() {
		return inStreaming;
	}
	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}

}
