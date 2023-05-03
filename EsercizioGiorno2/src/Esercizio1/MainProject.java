package Esercizio1;

/*
Esercizio #1
Creare una classe Rettangolo che permetta di rappresentare dei 
rettangoli. Per ogni rettangolo deve essere possibile specificare 
altezza e larghezza in fase di costruzione dell'istanza e 
devono essere realizzati i metodi per calcolare perimetro ed area. 
Realizzare una funzione stampaRettangolo che, dato un rettangolo, 
stampi a video area e perimetro. 
Realizzare una funzione stampaDueRettangoli che, dati due rettangoli, 
stampi area e perimetro di ognuno e quindi la somma delle aree e dei perimetri.
Scrivere un main che utilizzi tutte queste funzioni. 

*/

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rettangolo r1 = new Rettangolo(10, 25);
		Rettangolo r2 = new Rettangolo(25, 8);
		

		stampaDueRettangoli(r1,r2);
	}		
		
	
	public static void stampaRettangolo(Rettangolo r) {
			System.out.println("Area del Rettangolo: " + r.calcolaArea());
			System.out.println("Perimetro del Rettangolo: " + r.calcolaPerimetro());
		}
		
		public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
			stampaRettangolo(r1);
			stampaRettangolo(r2);
			System.out.println("Somma Area dei Rettangolo: " + (r1.calcolaArea() + r2.calcolaArea()));
			System.out.println("Somma Perimetri dei Rettangolo: " + (r1.calcolaPerimetro() + r2.calcolaPerimetro()));
		}
	
	
	

}

