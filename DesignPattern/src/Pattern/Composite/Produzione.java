package Pattern.Composite;

public class Produzione implements Settore {
	
	String name;

	public Produzione(String name) {
		this.name = name;
	}

	@Override
	public void stampaSettore() {
		System.out.println("Produzione");
		
	}

}
