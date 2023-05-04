package Esercizio3;

/*
 * Esercizio #3
Scrivere un’applicazione che simula il funzionamento di un e-commerce.
Si devono quindi rappresentare i dati relativi i seguenti elementi:
Articolo
- codice articolo
- descrizione articolo
- prezzo
- numero pezzi disponibili a magazzino
Cliente
- codice cliente
- nome e cognome
- email
- data iscrizione
Carrello
- cliente associato
- elenco articoli
- totale costo articoli

 */

public class MainProject {

	public static void main(String[] args) {

		Articolo a1 = new Articolo("AB001", "Smartphone super figo", 750.0, 2);
		Articolo a2 = new Articolo("AB002", "Super Tv LED", 359.0, 1);
		Articolo a3 = new Articolo("AB003", "Monopattino Volante", 999.0, 4);
		
		Cliente c1 = new Cliente("C001", "Mario Rossi", "m.rossi@example.com");
		Cliente c2 = new Cliente("C002", "Giuseppe Verdi", "g.verdi@example.com");

		Carrello carr1 = new Carrello(c1);
		carr1.aggiungiArticoloCarrello(a3);
		carr1.aggiungiArticoloCarrello(a1);
		carr1.aggiungiArticoloCarrello(a2);
		carr1.stampaCarrello();
	}

}
