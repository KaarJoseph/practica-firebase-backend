package ups.edu.ec.webapp.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.webapp.modelo.Espacio;

@Stateless
public class EspacioDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager es;
	
	public void insert(Espacio espacio) {
		es.persist(espacio);
	}
	
	public void update(Espacio espacio) {
		es.merge(espacio);
	}
	
	public Espacio read(int espacioId) {
		Espacio e = es.find(Espacio.class, espacioId);
		return e;
	}
	
	public void delete(int espacioId) {
		Espacio e = es.find(Espacio.class, espacioId);
		es.remove(e);
	}
	
	public List<Espacio> getAll(){
		String jpql = "SELECT e FROM Espacio e";
		Query q = es.createQuery(jpql);
		return q.getResultList();
	}
	
	public void imprimirDatos() {
	    List<Espacio> espacios = getAll();
	    
	    for (Espacio espacio: espacios) {
	        System.out.println("espacioId: " + espacio.getEspacioId());
	        System.out.println("numEspacio: " + espacio.getNumEspacio());
	        System.out.println("estado: " + espacio.getEstado());
	        System.out.println("costo: " + espacio.getCosto());
	        System.out.println("-----------------------------");
	    }
	}
}
