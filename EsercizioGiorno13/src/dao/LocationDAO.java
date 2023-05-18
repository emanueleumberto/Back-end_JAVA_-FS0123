package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Location;
import utils.JpaUtil;

public class LocationDAO implements ILocationDAO {

	@Override
	public void save(Location ev) {
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
	public Location getById(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Location loc =  em.find(Location.class, id);
			em.getTransaction().commit();
			return loc;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Location ev) {
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
	public void update(Location ev) {
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
	public List<Location> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("findAllLocation");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
