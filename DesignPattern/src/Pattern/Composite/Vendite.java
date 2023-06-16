package Pattern.Composite;

public class Vendite implements Settore {

	String name;

	public Vendite(String name) {
		this.name = name;
	}

	@Override
	public void stampaSettore() {
		System.out.println("Vendite");
		
	}

}
