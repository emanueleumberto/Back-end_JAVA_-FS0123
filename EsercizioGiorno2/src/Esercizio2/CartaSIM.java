package Esercizio2;

public class CartaSIM {
	
	public static double costoMinutoChiamata = 0.20;
	public String numeroTelefono;
	public double creditoDisponibile;
	public Chiamata[] chiamateEffettuate;
	
	public CartaSIM(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
		this.creditoDisponibile = 0;
		this.chiamateEffettuate = new Chiamata[5];
	}
	
	public void ricaricaSim(double importo) {
		this.creditoDisponibile += importo;
	}
	
	public void effettuaChiamata(String numero, int minuti) {

		if(this.creditoDisponibile > 0) {
			Chiamata c = new Chiamata(numero, minuti);
			System.out.println("Chiamata effettuata sul num. " + c.numeroChiamato + " min." + c.durataMinuti);
			this.creditoDisponibile -= minuti*costoMinutoChiamata;
			
			for (int i = 0; i < chiamateEffettuate.length; i++) {
				if(chiamateEffettuate[i] == null) {
					chiamateEffettuate[i] = c;
					break;
				}
			}
		} else {
			System.out.println("Non hai Credito disponibile");
		}
		
	}
	
	public void stampaDatiSIM() {
		System.out.println("SIM numero: " + this.numeroTelefono);
		System.out.println("Credito Disponibile: " + this.creditoDisponibile);
		System.out.println("Lista Ultime 5 chiamte: ");
		for (int i = 0; i < chiamateEffettuate.length; i++) {
			Chiamata c = chiamateEffettuate[i];
			if(c != null) {
				System.out.println(c.numeroChiamato + " min." + c.durataMinuti);
			}
		}
	}

}
