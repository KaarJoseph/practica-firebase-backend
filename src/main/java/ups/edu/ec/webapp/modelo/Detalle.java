package ups.edu.ec.webapp.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Detalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue
	private int detalleId;
	private Timestamp fechaIngreso;
	private Timestamp fechaSalida;
	private double costo;
	
	@ManyToOne
	private Espacio espacio;
	
	@ManyToOne
	private Cabecera cabecera;

	public int getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(int detalleId) {
		this.detalleId = detalleId;
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Espacio getEspacio() {
		return espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}
	
	@Override
	public String toString() {
		return "DetalleFactura [codigo=" + detalleId + ", Ingreso=" + fechaIngreso + ", Salida=" + fechaSalida + ", Espacio="
				+ espacio + "]";
	}
}
