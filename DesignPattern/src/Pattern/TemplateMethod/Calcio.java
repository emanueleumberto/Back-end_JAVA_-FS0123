package Pattern.TemplateMethod;

public class Calcio extends Gioco{

	@Override
	void inizializza() {
		System.out.println("Gioco del Calcio");		
	}

	@Override
	void start() {
		System.out.println("Inizio Gioco del Calcio");	
	}

	@Override
	void fine() {
		System.out.println("Fine Gioco del Calcio");
	}

}
