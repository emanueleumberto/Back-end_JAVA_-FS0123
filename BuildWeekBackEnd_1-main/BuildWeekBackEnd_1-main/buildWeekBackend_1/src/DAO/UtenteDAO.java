package DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.*;

import InterfaceDAO.IUtenteDAO;
import model.Utente;
import utils.JpaUtil;

public class UtenteDAO implements IUtenteDAO {
 private static Logger log=LoggerFactory.getLogger(UtenteDAO.class);
// private static EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void save(Utente u) {
		 EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			log.info("utente: " + u.getNome() +" "+ u.getCognome() + " aggiunto al database");
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
		}finally{
			em.close();
		}
		
	}

	@Override
	public Utente getByN_tessera(Integer n_tessera) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
//			em.getTransaction().begin();
			Utente u =  em.find(Utente.class, n_tessera);
//			em.getTransaction().commit();
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nel recupero dell'utente");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Utente u) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			log.info("Utente rimosso correttamente dal database");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nella rimozione dell'utente");
		} finally {
			em.close();
		}
		
	}

	@Override
	public void update(Utente u) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			log.info("Utente modificato corretamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nella modifica dell'utente");
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Utente> getAllUsers() {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Utente u");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
