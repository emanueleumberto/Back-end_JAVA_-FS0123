package Pattern.Prototype;

public abstract class Forma {
	
	public int x;
	public int y;
	public String color;
	
	public Forma() {}

	public Forma(int x, int y, String color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public abstract Forma clone();

}
