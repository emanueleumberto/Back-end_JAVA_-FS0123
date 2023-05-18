package model_MappedSuperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="Moto.findAll", query = "SELECT m FROM Moto4 m")
public class Moto4 extends Veicolo4 {
	
	private Integer nposti;
	private String cilindrata;
	
	public Integer getNposti() {
		return nposti;
	}
	public void setNposti(Integer nposti) {
		this.nposti = nposti;
	}
	public String getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(String cilindrata) {
		this.cilindrata = cilindrata;
	}
	@Override
	public String toString() {
		return "Moto1 [nposti=" + nposti + ", cilindrata=" + cilindrata + "]";
	}
	
	

}
