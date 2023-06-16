package Pattern.Prototype;

public class Rectangle extends Forma {

	public int larghezza;
	public int lunghezza;
	
	public Rectangle() {}
	
	public Rectangle(Rectangle r) {
		super();
		if(r != null) {
			this.larghezza = r.larghezza;
			this.lunghezza = r.lunghezza;
		}
	}

	@Override
	public Forma clone() {
		return new Rectangle(this);
	}
	
}
