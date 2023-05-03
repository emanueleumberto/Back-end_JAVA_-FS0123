package Esercizio2;

public class MainProject {
	
/*
 Esercizio #2
Scrivere un’applicazione che simula il funzionamento di un frammento del sistema 
informativo di un operatore di telefonia cellulare.

Si devono quindi rappresentare i dati relativi ad una carta SIM, ed in particolare:
- il numero di telefono
- il credito disponibile in euro
- la lista delle ultime 5 chiamate effettuate
Per ciascuna chiamata deve essere rappresentata la durata in minuti e il numero chiamato
La classe SIM dovrà  fornire le seguenti funzionalità:
- un costruttore che crea una SIM con numero di telefono passato come parametro, 
credito a 0 e lista delle chiamate vuota
una funzione per la stampa dei dati della SIM

Scrivere un main che crei una istanza di SIM e ne stampi i dati.

 */

	public static void main(String[] args) {

		CartaSIM s1 = new CartaSIM("123456789");
		s1.ricaricaSim(10);
		s1.effettuaChiamata(new Chiamata("3296530", 5));
		s1.effettuaChiamata(new Chiamata("9783952", 2));
		s1.effettuaChiamata(new Chiamata("1243512", 4));
		s1.stampaDatiSIM();

	}

}
