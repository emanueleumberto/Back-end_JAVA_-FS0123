package controller;

import java.time.LocalDate;

import Enumerations.GenereConcerto;
import Enumerations.Sesso;
import Enumerations.StatoPartecipazione;
import Enumerations.TipoEvento;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioniDAO;
import dao.PersonaDAO;
import model.Concerto;
import model.Location;
import model.Partecipazione;
import model.Persona;

public class MainProject {

	public static void main(String[] args) {
		
		Location l1 = new Location();
		l1.setNome("Epicode");
		l1.setCitta("Roma");
		
		LocationDAO ld1 = new LocationDAO();
		ld1.save(l1);
		
		Concerto c1 = new Concerto();
		c1.setTitolo("SuperConcerto");
		c1.setDataEvento(LocalDate.now());
		c1.setDescrizione("Super concerto Epicode");
		c1.setGenere(GenereConcerto.ROCK);
		c1.setInStreaming(true);
		c1.setLocation(l1);
		c1.setNumeroMassimoPartecipanti(10);
		c1.setTipoEvento(TipoEvento.PRIVATO);

		EventoDAO evd1 = new EventoDAO();
		evd1.save(c1);
		
		Persona p1 = new Persona("Mario", "Rossi", "m.rossi@example.com", LocalDate.of(2000, 8, 15) , Sesso.MASCHIO);

		PersonaDAO pd1 = new PersonaDAO();
		pd1.save(p1);
		
		Partecipazione par1 = new Partecipazione(p1, c1, StatoPartecipazione.CONFERMATA);
		
		PartecipazioniDAO pard1 = new PartecipazioniDAO();
		pard1.save(par1);
	}

}
