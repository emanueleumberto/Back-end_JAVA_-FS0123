package Pattern.TemplateMethod;

public class Moto extends Gioco{

	@Override
	void inizializza() {
		System.out.println("Gioco delle Moto");		
	}

	@Override
	void start() {
		System.out.println("Inizio Gioco delle Moto");	
	}

	@Override
	void fine() {
		System.out.println("Fine Gioco delle Moto");
	}

}
