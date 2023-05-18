package model_TABLE_PER_CLASS;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject3 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("JPAEreditarieta").createEntityManager();

	public static void main(String[] args) {
		
		Automobile3 a1 = new Automobile3();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setNporte(3);
		a1.setAlimentazione("Benzina");
		
		Moto3 m1 = new Moto3();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(2);
		
		save(a1);
		save(m1);

	}
	
	public static void save(Veicolo3 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
