package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import DAO.BiglietteriaDAO;
import DAO.LuogoDAO;
import DAO.TitoloViaggioDAO;
import DAO.UtenteDAO;
import model.Abbonamento;
import model.Biglietteria;
import model.Biglietto;
import model.Luogo;
import model.Rivenditore;
import model.TitoloViaggio;
import model.Utente;
import utils.DurataAbb;
import utils.JpaUtil;
import utils.TipoNegozio;

public class MainProject {

	
	public static void main(String[] args) {
	JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO u = new UtenteDAO();
		TitoloViaggioDAO t = new TitoloViaggioDAO();
		BiglietteriaDAO bg = new BiglietteriaDAO();
		LuogoDAO lg = new LuogoDAO();
	
		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 1, 27));
		u.save(u1);
		System.out.println(u1);
		
		Utente u2 = new Utente("Mario", "Rossi", LocalDate.of(1997, 1, 27));
		u.save(u2);
		System.out.println(u2);
		
		Luogo l1=new Luogo("Roma","Roma","Termini");
		lg.save(l1);
		System.out.println(l1);
		
		Biglietteria r1=new Rivenditore(TipoNegozio.EDICOLA, l1);
		bg.save(r1);
		System.out.println(r1);

// System.out.println(biglietteria);
//	biglietteria.getTitoliEmessi().forEach(b-> System.out.println(b));;

		TitoloViaggio t1 =new Biglietto(LocalDate.of(2023, 3, 15), r1);
		t.save(t1);
		System.out.println(t1);

		TitoloViaggio a2 = new Abbonamento(DurataAbb.MENSILI, r1, u1);
		t.save(a2);
		System.out.println(a2);
		
		TitoloViaggio a3 = new Abbonamento(DurataAbb.SETTIMANALI, r1, u1);
		t.save(a3);
		System.out.println(a3);
		
		Utente u5000 = u.getByN_tessera(5000);
		System.out.println(u5000);
		u5000.getAbbonamentiAcquistati().forEach(a -> System.out.println(a));
		
//		TitoloViaggio a3 = new Abbonamento(DurataAbb.SETTIMANALI, r1, u2);
//	emettiTitolo(a3);
		
//	biglietteria.emettiTitolo(DurataAbb.GIORNALIERO, u2m.getTessera());
	//	biglietteria.emettiTitolo(DurataAbb.GIORNALIERO, null);
	}
	
	
}
