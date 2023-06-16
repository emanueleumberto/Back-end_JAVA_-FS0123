package Pattern.AbstractFactory;

public class PersonFactory implements AbstractFactory<Person> {

	@Override
	public Person create(String type) {
		if(type.equalsIgnoreCase("Uomo")) {
			return new Man();
		} else if(type.equalsIgnoreCase("Donna")) {
			// return new Woman();
		}
		return null;
	}

}
