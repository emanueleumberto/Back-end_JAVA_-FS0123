package dao;

import java.util.List;

import model.Persona;

public interface IPersonaDAO {
	
	public void save(Persona e);
	public Persona getById(int id);
	public void delete(Persona e);
	public void update(Persona e);
	public List<Persona> getAll();

}
