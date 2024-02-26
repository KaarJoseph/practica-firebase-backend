package ups.edu.ec.webapp.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.webapp.modelo.Persona;

@Stateless
public class PersonaDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(String cedula) {
		Persona p = em.find(Persona.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		Persona p = em.find(Persona.class, cedula);
		em.remove(p);
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT p FROM Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	public void imprimirDatos() {
	    List<Persona> personas = getAll();
	    
	    for (Persona persona : personas) {
	        System.out.println("Cédula: " + persona.getCedula());
	        System.out.println("Nombre: " + persona.getNombre());
	        System.out.println("Dirección: " + persona.getDireccion());
	        System.out.println("-----------------------------");
	    }
	}

	
}