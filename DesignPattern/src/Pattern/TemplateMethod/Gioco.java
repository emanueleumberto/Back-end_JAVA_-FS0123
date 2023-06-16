package Pattern.TemplateMethod;

public abstract class Gioco {
	abstract void inizializza();
	abstract void start();
	abstract void fine();
	
	public void play() {
		inizializza();
		start();
		fine();
	}
}
