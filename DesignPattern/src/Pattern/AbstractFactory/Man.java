package Pattern.AbstractFactory;

public class Man implements Person {

	@Override
	public String getPerson() {
		return "Man";
	}

	@Override
	public String makeSound() {
		return "Ciao!!";
	}

}
