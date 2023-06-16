package Pattern.Prototype;

public class Circle extends Forma {
	
	public int raggio;

	public Circle() {}

	public Circle(Circle c) {
		if(c != null) {
			this.raggio = c.raggio;
		}
	}

	@Override
	public Forma clone() {
		return new Circle(this);
	}

	

}
