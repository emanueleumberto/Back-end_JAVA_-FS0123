package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import InterfaceDAO.ILuogoDAO;
import model.Luogo;
import utils.JpaUtil;

public class LuogoDAO implements ILuogoDAO {
	private static Logger log=LoggerFactory.getLogger(LuogoDAO.class);
	@Override
	public void save(Luogo bi) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			em.getTransaction().begin();
			em.persist(bi);
			em.getTransaction().commit();
			log.info("Luogo salvato correttamente");
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
		}finally{
			em.close();
		}
		
	}

	@Override
	public Luogo getById(Integer id) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
//			em.getTransaction().begin();
			Luogo u =  em.find(Luogo.class, id);
//			em.getTransaction().commit();
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nel recupero del Luogo");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Luogo bi) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(bi);
			em.getTransaction().commit();
			log.info("Luogo rimosso correttamente dal database");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nella rimozione del Luogo");
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Luogo> getAllUsers() {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Luogo u");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
