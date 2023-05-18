package model_SINGLE_TABLE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Moto")
public class Moto1 extends Veicolo1 {
	
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
