package Pattern.AbstractFactory;

public class AnimalFactory implements AbstractFactory<Animal> {

	@Override
	public Animal create(String type) {
		if(type.equalsIgnoreCase("Dog")) {
			return new Dog();
		} else if(type.equalsIgnoreCase("Altro")) {
			// return new Altro()....
		}
		return null;
	}

}
