package Esercizio3;

public class Carrello {
	
	public Cliente clienteAssociato;
	public Articolo[] elencoArticoli;
	public double totaleCostoArticoli;
	
	public Carrello(Cliente clienteAssociato) {
		this.clienteAssociato = clienteAssociato;
		this.elencoArticoli = new Articolo[10];
		this.totaleCostoArticoli = 0;
	}

}
