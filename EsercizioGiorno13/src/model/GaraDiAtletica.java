package model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class GaraDiAtletica extends Evento {
	
	@ManyToMany
	private Set<Persona> setAtleti;
	
	@ManyToOne
	private Persona vincitore;

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [setAtleti=" + setAtleti + ", vincitore=" + vincitore + "]";
	}

}
