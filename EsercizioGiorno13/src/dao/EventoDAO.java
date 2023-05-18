package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Enumerations.GenereConcerto;
import model.Concerto;
import model.Evento;
import utils.JpaUtil;

public class EventoDAO implements IEventoDAO {
	
//	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelazioniJPA");
//	static EntityManager em = emf.createEntityManager();

	@Override
	public void save(Evento ev) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();
			System.out.println("Evento salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}
	}

	@Override
	public Evento getById(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Evento evt =  em.find(Evento.class, id);
			em.getTransaction().commit();
			return evt;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Evento ev) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(ev);
			em.getTransaction().commit();
			System.out.println("Evento salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Evento ev) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(ev);
			em.getTransaction().commit();
			System.out.println("Evento salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}

	}

	@Override
	public List<Evento> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// Dynamic Query 
			//Query q = em.createQuery("SELECT ev FROM Evento ev");
			// Named Query
			Query q = em.createNamedQuery("findAllEventi");
			return q.getResultList();
		} finally {
			em.close();
		}
	
	}

	@Override
	public List<Concerto> getConcertiInStreaming(Boolean streaming) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			//Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :streaming");
			Query q = em.createNamedQuery("concertiInStreaming");
			q.setParameter("streaming", streaming);
			return q.getResultList();
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Concerto> getConcertiPerGenere(List<GenereConcerto> generiConcerto) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
																				//('Rock', 'Punk', 'Metal')
			//Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.genere IN :listaGenere");
			Query q = em.createNamedQuery("concertiPerGenere");
			q.setParameter("streaming", generiConcerto);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
