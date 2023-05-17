package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Citta;
import entity.CorsiOnline;
import entity.Smartphone;
import entity.Utente;

public class MainProject {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelazioniJPA");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
//		Smartphone s = new Smartphone("Iphone", "Apple", "64");
//		Citta c = new Citta("Roma", "Roma", "Lazio");
//		Utente u = new Utente("Mario", "Rossi", 45, c, s);
//		CorsiOnline java = new CorsiOnline("BackEndDev", 100);
//		addUtente(u);
//		Utente u2 = new Utente("Giuseppe", "Verdi", 21, findCitta(1), new Smartphone("Galaxy", "Samsung", "128"));
//		addUtente(u2);
		
//		Utente mario = findUtente(4);
//		mario.addCorso(java);
//		updateUtente(mario);
//		System.out.println(mario);
//		Utente giuseppe = findUtente(5);
//		giuseppe.addCorso(findCorsoOnline(1));
//		updateUtente(giuseppe);
//		
//		giuseppe.getListaCorsi().forEach(c -> System.out.println(c));

//		Smartphone iphone = findSmartphone(1);
//		System.out.println(iphone.getUtente().getNome());
		
//		Citta roma = findCitta(1);
//		roma.getUtenti().forEach(u -> System.out.println(u));
		
		CorsiOnline backEndDev = findCorsoOnline(1);
		backEndDev.getPartecipanti().forEach(p -> System.out.println(p));
		
//		removeUtente(mario);
	}
	
	public static void addUtente(Utente u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente salvato nel DB!!");
	}
	
	public static Utente findUtente(int id) {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public static void removeUtente(Utente u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("Utente eliminato nel DB!!");
	}
	
	public static void updateUtente(Utente u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Utente modificato nel DB!!");
	}
	
	public static Smartphone findSmartphone(int id) {
		em.getTransaction().begin();
		Smartphone s = em.find(Smartphone.class, id);
		em.getTransaction().commit();
		return s;
	}
	
	public static Citta findCitta(int id) {
		em.getTransaction().begin();
		Citta c = em.find(Citta.class, id);
		em.getTransaction().commit();
		return c;
	}
	
	public static CorsiOnline findCorsoOnline(int id) {
		em.getTransaction().begin();
		CorsiOnline c = em.find(CorsiOnline.class, id);
		em.getTransaction().commit();
		return c;
	}

	
}
