package model_JOINED;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject2 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("JPAEreditarieta").createEntityManager();

	public static void main(String[] args) {
		
		Automobile2 a1 = new Automobile2();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setNporte(3);
		a1.setAlimentazione("Benzina");
		
		Moto2 m1 = new Moto2();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(2);
		
		save(a1);
		save(m1);

	}
	
	public static void save(Veicolo2 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
