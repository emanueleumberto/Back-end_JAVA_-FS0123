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
			
			Cliente c = leggiCliente(1);
			System.out.println(c);
			
//			c.setRegioneResidenza("Lazio");
//			modificaCliente(c);
			
			eleiminaCliente(c);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public static void eleiminaCliente(Cliente c) {
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
