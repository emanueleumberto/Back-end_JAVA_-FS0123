package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Evento;
import model.Persona;
import utils.JpaUtil;

public class PersonaDAO implements IPersonaDAO {

	@Override
	public void save(Persona ev) {
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
	public Persona getById(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Persona evt =  em.find(Persona.class, id);
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
	public void delete(Persona ev) {
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
	public void update(Persona ev) {
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
	public List<Persona> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("findAllPersone");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
