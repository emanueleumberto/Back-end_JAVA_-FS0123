package Pattern.AbstractFactory;

public interface AbstractFactory<T> {
	T create(String type);
}
