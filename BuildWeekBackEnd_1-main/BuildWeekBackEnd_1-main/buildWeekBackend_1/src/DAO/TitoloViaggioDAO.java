package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import InterfaceDAO.ITitoloViaggioDAO;
import model.Abbonamento;
import model.TitoloViaggio;
import model.Utente;
import utils.JpaUtil;

public class TitoloViaggioDAO implements ITitoloViaggioDAO {
	private static Logger log=LoggerFactory.getLogger(TitoloViaggioDAO.class);
		
		@Override
		public void save(TitoloViaggio t) {
			EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.persist(t);
				em.getTransaction().commit();				
				log.info("TitoloViaggio salvato correttamente");
			}catch(Exception ex) {
				em.getTransaction().rollback();
				log.error(ex.getMessage());
			}finally{
				em.close();
			}	
		}
		
		@Override
		public TitoloViaggio getByCodice(Integer codice) {
			EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
//				em.getTransaction().begin();
				TitoloViaggio u =  em.find(TitoloViaggio.class, codice);
//				em.getTransaction().commit();
				return u;
			} catch (Exception e) {
				em.getTransaction().rollback();
				log.error("Errore nel recupero del TitoloViaggio");
			} finally {
				em.close();
			}
			return null;
		}
		
		@Override
		public void delete(TitoloViaggio ti) {
			EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.remove(ti);
				em.getTransaction().commit();
				log.info("TitoloViaggio rimosso correttamente dal database");
			} catch (Exception e) {
				em.getTransaction().rollback();
				log.error("Errore nella rimozione del TitoloViaggio");
			} finally {
				em.close();
			}
			
		}
		@Override
		public List<TitoloViaggio> getAllTitoli() {
			EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
				Query q = em.createQuery("SELECT u FROM TitoloViaggio u");
				return q.getResultList();
			} finally {
				em.close();
			}
			}
		
}