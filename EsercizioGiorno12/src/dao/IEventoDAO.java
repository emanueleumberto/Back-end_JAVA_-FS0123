package dao;

import java.util.List;

import model.Evento;

public interface IEventoDAO {
	
	public void save(Evento e);
	public Evento getById(int id);
	public void delete(Evento e);
	public void update(Evento e);
	public List<Evento> getAll();

}
