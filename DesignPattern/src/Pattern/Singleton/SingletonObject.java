package Pattern.Singleton;

public class SingletonObject {
	
	private static Saluto i;

	private SingletonObject() {
		super();
	}

	public static Saluto getObj() {
		if(i == null) {
			i = new Saluto();
		}
		return i;
	}
}
