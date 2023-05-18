package model_JOINED;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Moto2 extends Veicolo2 {
	
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
