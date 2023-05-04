package ParadigmiOOP;

public class Persona extends Object {
	
	private String nome;
	private String cognome;
	private String citta;
	private int eta;
	
	public Persona(String nome, String cognome, String citta, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.eta = eta;
	}
	
	public String getNome() {
		// controlli 
		return this.nome;
	}
	
	public String getCognome() {
		// controlli 
		return this.cognome;
	}
	
	public String getCitta() {
		// controlli 
		return this.citta;
	}
	
	public void setCitta(String citta) {
		// controlli 
		this.citta = citta;
	}
	
	public int getEta() {
		// controlli 
		return this.eta;
	}
	
	public void setEta(int eta) {
		// controlli 
		this.eta = eta;
	}


	@Override
	public String toString() {
		return this.nome + " " + this.cognome + " " + this.citta + " " + this.eta;
	}


}
