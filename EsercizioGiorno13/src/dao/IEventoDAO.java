package dao;

import java.util.List;

import Enumerations.GenereConcerto;
import model.Concerto;
import model.Evento;

public interface IEventoDAO {
	
	public void save(Evento e);
	public Evento getById(int id);
	public void delete(Evento e);
	public void update(Evento e);
	public List<Evento> getAll();
	public List<Concerto> getConcertiInStreaming(Boolean streaming);
	public List<Concerto> getConcertiPerGenere(List<GenereConcerto> generiConcerto);

}
