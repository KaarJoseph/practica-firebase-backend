package ups.edu.ec.webapp.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Espacio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue
    private int espacioId;
    private int numEspacio;
    private String estado;
    private double costo;
    
    @OneToMany(mappedBy = "espacio")
    private List<Detalle> detalles;

	public int getEspacioId() {
		return espacioId;
	}

	public void setEspacioId(int espacioId) {
		this.espacioId = espacioId;
	}

	public int getNumEspacio() {
		return numEspacio;
	}

	public void setNumEspacio(int numEspacio) {
		this.numEspacio = numEspacio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	@Override
	public String toString() {
		return "Espacio [codigo=" + espacioId + ", Numero=" + numEspacio + ", Estado=" + estado + ", costo=" + costo + "]";
	}
}

