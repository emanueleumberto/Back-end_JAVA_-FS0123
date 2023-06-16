package Pattern.Composite;

import java.util.ArrayList;
import java.util.List;

public class Direzione implements Settore {
	
	String name;
	
	List<Settore> listaSettori;

	public Direzione(String name) {
		super();
		this.name = name;
		this.listaSettori = new ArrayList<>();
	}
	
	public void aggiungiSettore(Settore s) {
		listaSettori.add(s);
	}
	
	public void rimuoviSettore(Settore s) {
		listaSettori.remove(s);
	}

	@Override
	public void stampaSettore() {
		listaSettori.forEach(s -> s.stampaSettore());
	}

}
