package InterfaceDAO;

import java.util.List;

import model.Biglietteria;
import model.Luogo;

public interface ILuogoDAO {
	public void save(Luogo bi);
	public Luogo getById(Integer id);
	public void delete(Luogo bi);
	public List<Luogo>  getAllUsers();
}
