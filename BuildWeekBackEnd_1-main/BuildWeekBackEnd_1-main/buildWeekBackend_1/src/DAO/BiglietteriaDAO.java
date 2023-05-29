package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import InterfaceDAO.IBiglietteriaDAO;
import model.Biglietteria;
import model.Utente;
import utils.JpaUtil;

public class BiglietteriaDAO implements IBiglietteriaDAO {
	private static Logger log=LoggerFactory.getLogger(BiglietteriaDAO.class);
	@Override
	public void save(Biglietteria bi) {
		 EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
				
				em.getTransaction().begin();
				em.persist(bi);
				em.getTransaction().commit();
				log.info("Biglietteria salvata correttamente");
			}catch(Exception ex) {
				em.getTransaction().rollback();
				log.error(ex.getMessage());
			}finally{
				em.close();
			}
		
	}

	@Override
	public Biglietteria getById(Integer id) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
//			em.getTransaction().begin();
			Biglietteria u =  em.find(Biglietteria.class, id);
//			em.getTransaction().commit();
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nel recupero della Biglietteria");
		} finally {
			em.close();
		}
		return null;
	}
	
	@Override
	public void update(Biglietteria b) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
			log.info("Biglietteria aggiornata corretamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nella modifica della biglietteria");
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(Biglietteria bi) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(bi);
			em.getTransaction().commit();
			log.info("Biglietteria rimosso correttamente dal database");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nella rimozione della Biglietteria");
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Biglietteria> getAllUsers() {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Biglietteria u");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
