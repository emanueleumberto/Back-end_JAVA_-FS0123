package model_MappedSuperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="Automobile4.findAll", query = "SELECT a FROM Automobile4 a")
@NamedQuery(name ="AutomobileByMarca.findAll", query = "SELECT a FROM Automobile4 a WHERE a.marca LIKE :marca_auto")
public class Automobile4 extends Veicolo4 {
	
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
		return super.toString() + "Automobile [nporte=" + nporte + ", alimentazione=" + alimentazione + "]";
	}
	
	

}
