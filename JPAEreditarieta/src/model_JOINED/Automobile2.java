package model_JOINED;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Automobile2 extends Veicolo2 {
	
	private Integer nporte;
	private String alimentazione;
	
	public Integer getNporte() {
		return nporte;
	}
	public void setNporte(Integer nporte) {
		this.nporte = nporte;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	@Override
	public String toString() {
		return "Automobile1 [nporte=" + nporte + ", alimentazione=" + alimentazione + "]";
	}
	
	

}
