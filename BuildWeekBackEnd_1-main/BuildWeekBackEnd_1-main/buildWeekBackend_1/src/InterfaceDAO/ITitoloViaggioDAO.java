package InterfaceDAO;

import java.util.List;

import model.TitoloViaggio;
import model.Utente;

public interface ITitoloViaggioDAO {
	public void save(TitoloViaggio ti);
	public TitoloViaggio getByCodice(Integer codice);
	public void delete(TitoloViaggio ti);
	public List<TitoloViaggio>  getAllTitoli();
}
