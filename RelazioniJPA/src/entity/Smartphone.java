package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smartphone")
public class Smartphone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modello;
	private String marca;
	private String memoria;
	
	@OneToOne(mappedBy = "smartphone")
	private Utente utente;

	public Smartphone() {
		super();
	}

	public Smartphone(String modello, String marca, String memoria) {
		super();
		this.modello = modello;
		this.marca = marca;
		this.memoria = memoria;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Smartphone [modello=" + modello + ", marca=" + marca + ", memoria=" + memoria + "]";
	}

}
