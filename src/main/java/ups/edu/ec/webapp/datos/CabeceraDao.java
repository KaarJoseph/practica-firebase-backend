package ups.edu.ec.webapp.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.webapp.modelo.Cabecera;

@Stateless
public class CabeceraDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager ca;
	
	public void insert(Cabecera cabecera) {
		ca.persist(cabecera);
	}
	
	public void update(Cabecera cabecera) {
		ca.merge(cabecera);
	}
	
	public Cabecera read(int cabeceraId) {
		Cabecera e = ca.find(Cabecera.class, cabeceraId);
		return e;
	}
	
	public void delete(int cabeceraId) {
		Cabecera e = ca.find(Cabecera.class, cabeceraId);
		ca.remove(e);
	}
	
	public List<Cabecera> getAll(){
		String jpql = "SELECT c FROM Cabecera c";
		Query q = ca.createQuery(jpql);
		return q.getResultList();
	}
	
	public void imprimirDatos() {
	    List<Cabecera> cabeceras = getAll();
	    
	    for (Cabecera cabecera: cabeceras) {
	        System.out.println("cabeceraId: " + cabecera.getTicketInt());
	        System.out.println("numCabecera: " + cabecera.getNumTicket());
	        System.out.println("estado: " + cabecera.getEstado());
	        System.out.println("-----------------------------");
	    }
	}
}
