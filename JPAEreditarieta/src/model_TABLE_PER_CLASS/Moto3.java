package model_TABLE_PER_CLASS;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Moto3 extends Veicolo3 {
	
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
