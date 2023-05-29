package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="luoghi")
public class Luogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String provincia;
	
	@Column(nullable=false)
	private String citta;
	
	@Column(nullable=false, unique = true)
	private String nome;
	

	public Luogo() {
		super();
	}

	public Luogo(String provincia, String citta, String nome) {
		super();
		this.provincia = provincia;
		this.citta = citta;
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Luogo [id=" + id + ", provincia=" + provincia + ", citta=" + citta + ", nome=" + nome
				+ "]";
	}
	
	
}
