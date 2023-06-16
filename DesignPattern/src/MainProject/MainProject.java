package MainProject;

import Pattern.AbstractFactory.AbstractFactory;
import Pattern.AbstractFactory.Animal;
import Pattern.AbstractFactory.FactoryProvider;
import Pattern.Factory.CreaDisegno;
import Pattern.Factory.Disegno;
import Pattern.Prototype.Circle;
import Pattern.Singleton.Saluto;
import Pattern.Singleton.SingletonObject;

public class MainProject {

	public static void main(String[] args) {
	
		// Pattern Singleton
		//SingletonObject s = new SingletonObject();
		Saluto saluto1 = SingletonObject.getObj();
		Saluto saluto2 = SingletonObject.getObj();
		Saluto saluto3 = SingletonObject.getObj();
		Saluto saluto4 = SingletonObject.getObj();
		
		System.out.println(saluto1);
		System.out.println(saluto2);
		System.out.println(saluto3);
		System.out.println(saluto4);
		
		// Factory Pattern
		
		Disegno d1 = CreaDisegno.getForma("CERCHIO");
		Disegno d2 = CreaDisegno.getForma("RETTANGOLO");
		d1.disegna();
		d2.disegna();
		
		// Prototype Pattern
		
		Circle c = new Circle();
		c.x = 10;
		c.y = 20;
		c.raggio = 25;
		c.color = "Rosso";
		
//		Circle c1 = new Circle();
//		c1.x = 10;
//		c1.y = 20;
//		c1.raggio = 25;
//		c1.color = "Rosso";
		
		Circle c1 = (Circle) c.clone();
		c1.color = "Verde";
				
		// AbstractFactory Pattern
		
		AbstractFactory costruttoreAnimali =  FactoryProvider.getFactory("Animal");
		Animal d = (Animal) costruttoreAnimali.create("Dog");
		AbstractFactory costruttorePersone =  FactoryProvider.getFactory("Person");
		costruttorePersone.create("Uomo");

	}

}
