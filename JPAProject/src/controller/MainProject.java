package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class MainProject {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {

		try {
			
//			Cliente c = new Cliente();
//			c.setNome("Marco");
//			c.setCognome("Viola");
//			c.setRegioneResidenza("Toscana");
//			c.setDataNascita(LocalDate.of(1980, 11, 22));
//			c.setEmail("m.viola@example.com");
//			inserisciCliente(c);
			
//			Cliente c2 = new Cliente("Mario", "Rossi", LocalDate.of(1993, 5, 19), "m.rossi@example.com", "Campania");
//			inserisciCliente(c2);
			
//			Cliente c = leggiCliente(2);
//			System.out.println(c);
			
//			c.setRegioneResidenza("Lazio");
//			modificaCliente(c);
			
//			eliminaCliente(c);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
	}
	
	public static void inserisciCliente(Cliente c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		System.out.println( c.getNome() + " " + c.getCognome() + " salvato nel DB!!");
	}
	
	public static void modificaCliente(Cliente c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
	public static void eliminaCliente(Cliente c) {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
	
	public static Cliente leggiCliente(Integer id) {
		em.getTransaction().begin();
		Cliente c = em.find(Cliente.class, id);
		em.getTransaction().commit();
		return c;
	}
	
}
