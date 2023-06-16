package Pattern.AbstractFactory;

public class Dog implements Animal {

	@Override
	public String getAnimal() {
		return "Dog";
	}

	@Override
	public String makeSound() {
		return "Bau!!";
	}

}
