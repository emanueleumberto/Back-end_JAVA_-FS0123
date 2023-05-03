package Esercizio1;

public class Rettangolo {
	
	public double altezza;
	public double larghezza;

	public Rettangolo(double altezza, double larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public double calcolaPerimetro() {
		return this.altezza*2+this.larghezza*2;
	}
	
	public double calcolaArea() {
		return this.altezza * this.larghezza;
	}
	
	

}
