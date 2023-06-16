package Pattern.AbstractFactory;

public class FactoryProvider {
	
	public static AbstractFactory getFactory(String obj) {
		if(obj.equalsIgnoreCase("Animal")) {
			return new AnimalFactory();
		} else if(obj.equalsIgnoreCase("Persona")) {
			return new PersonFactory();
		}
		
		return null;
	}
}
