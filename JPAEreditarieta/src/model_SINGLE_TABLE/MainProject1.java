package model_SINGLE_TABLE;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject1 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("JPAEreditarieta").createEntityManager();

	public static void main(String[] args) {
		
		Automobile1 a1 = new Automobile1();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setNporte(3);
		a1.setAlimentazione("Benzina");
		
		Moto1 m1 = new Moto1();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(2);
		
		save(a1);
		save(m1);

	}
	
	public static void save(Veicolo1 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
