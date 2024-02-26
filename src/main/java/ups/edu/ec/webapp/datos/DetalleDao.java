package ups.edu.ec.webapp.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.webapp.modelo.Detalle;

@Stateless
public class DetalleDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager de;
	
	public void insert(Detalle detalle) {
		de.persist(detalle);
	}
	
	public void update(Detalle detalle) {
		de.merge(detalle);
	}
	
	public Detalle read(int detalleId) {
		Detalle e = de.find(Detalle.class, detalleId);
		return e;
	}
	
	public void delete(int detalleId) {
		Detalle e = de.find(Detalle.class, detalleId);
		de.remove(e);
	}
	
	public List<Detalle> getAll(){
		String jpql = "SELECT d FROM Detalle d";
		Query q = de.createQuery(jpql);
		return q.getResultList();
	}
	
	public void imprimirDatos() {
	    List<Detalle> detalles = getAll();
	    
	    for (Detalle detalle: detalles) {
	        System.out.println("detalleId: " + detalle.getDetalleId());
	        System.out.println("numDetalle: " + detalle.getCosto());
	        System.out.println("estado: " + detalle.getFechaIngreso());
	        System.out.println("-----------------------------");
	    }
	}
}
