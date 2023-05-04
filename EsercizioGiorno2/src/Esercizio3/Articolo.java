package Esercizio3;

public class Articolo {

	public String codiceArticolo;
	public String descrizioneArticolo;
	public double prezzo;
	public int numeroPezziDisponibili;
	
	public Articolo(String codiceArticolo, String descrizioneArticolo, double prezzo, int numeroPezziDisponibili) {
		this.codiceArticolo = codiceArticolo;
		this.descrizioneArticolo = descrizioneArticolo;
		this.prezzo = prezzo;
		this.numeroPezziDisponibili = numeroPezziDisponibili;
	}
	
}
