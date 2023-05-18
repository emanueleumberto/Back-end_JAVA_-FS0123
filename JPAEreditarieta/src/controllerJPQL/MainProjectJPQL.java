package controllerJPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model_MappedSuperclass.Automobile4;

public class MainProjectJPQL {
	
	static EntityManager em = Persistence.createEntityManagerFactory("JPAEreditarieta").createEntityManager();


	public static void main(String[] args) {
		
//		List<Automobile4> listaAuto = automobiliFindAll();
//		listaAuto.forEach(a -> System.out.println(a));
		
//		List<Automobile4> listaAutoFiat = automobiliByMarca("Ford");
//		listaAutoFiat.forEach(a -> System.out.println(a));
		
		List<Automobile4> listaAutoFiat = automobiliByMarcaCriteria("Ford");
		listaAutoFiat.forEach(a -> System.out.println(a));
	}
	
	public static List<Automobile4> automobiliFindAll() {
		Query q = em.createNamedQuery("Automobile4.findAll");
		return q.getResultList();
	}
	
	public static List<Automobile4> automobiliByMarca(String marca) {
		//Query q = em.createNamedQuery("AutomobileByMarca.findAll");
								//SELECT a FROM Automobile4 a WHERE a.marca LIKE :marca_auto 
		Query q = em.createQuery("SELECT a FROM Automobile4 a WHERE a.marca LIKE :marca_auto");
		q.setParameter(":marca_auto", marca);
		return q.getResultList();
	}
	
	public static List<Automobile4> automobiliByMarcaCriteria(String marca) {
		
		// JPQL
		//Query q = em.createQuery("SELECT a FROM Automobile4 a WHERE a.marca LIKE :marca_auto");
		//q.setParameter(":marca_auto", marca);
		//return q.getResultList();
		
		//CRITERIA API
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Automobile4> q = cb.createQuery(Automobile4.class);
		Root<Automobile4> c = q.from(Automobile4.class);
		ParameterExpression<String> p = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("marca"), p));
		
		Query query = em.createQuery(q);
		query.setParameter(p, marca);
		return query.getResultList();
		
	}

}
