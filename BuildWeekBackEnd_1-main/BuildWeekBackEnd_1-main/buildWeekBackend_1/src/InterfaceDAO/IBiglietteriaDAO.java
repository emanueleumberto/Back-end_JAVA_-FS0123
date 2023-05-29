package InterfaceDAO;

import java.util.List;

import model.Biglietteria;

public interface IBiglietteriaDAO {
	public void save(Biglietteria bi);
	public Biglietteria getById(Integer id);
	public void delete(Biglietteria bi);
	public List<Biglietteria>  getAllUsers();
	public void update(Biglietteria b);
}
