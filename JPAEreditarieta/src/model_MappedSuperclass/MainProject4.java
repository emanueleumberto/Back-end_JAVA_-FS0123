package model_MappedSuperclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject4 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("JPAEreditarieta").createEntityManager();

	public static void main(String[] args) {
		
		Automobile4 a1 = new Automobile4();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setNporte(3);
		a1.setAlimentazione("Benzina");
		
		Automobile4 a2 = new Automobile4();
		a2.setMarca("Ford");
		a2.setModello("Fiesta");
		a2.setNporte(5);
		a2.setAlimentazione("Diesel");
		
		Automobile4 a3 = new Automobile4();
		a3.setMarca("Smart");
		a3.setModello("ForTwo");
		a3.setNporte(2);
		a3.setAlimentazione("Benzina");
		
		Moto4 m1 = new Moto4();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(2);
		
		Moto4 m2 = new Moto4();
		m2.setMarca("Ducati");
		m2.setModello("Monster");
		m2.setCilindrata("1200cc");
		m2.setNposti(1);
		
		//save(a3);
		//save(m2);

	}
	
	public static void save(Veicolo4 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
