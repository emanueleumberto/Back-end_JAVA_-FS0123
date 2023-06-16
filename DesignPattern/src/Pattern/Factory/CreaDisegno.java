package Pattern.Factory;

public class CreaDisegno {
	
	public static Disegno getForma(String forma) {
		
		if(forma == null) {
			return null;
		} else if(forma.equalsIgnoreCase("CERCHIO")) {
			return new Cerchio();
		} else if(forma.equalsIgnoreCase("RETTANGOLO")) {
			return new Rettangolo();
		}
		
		return null;
	}

}
