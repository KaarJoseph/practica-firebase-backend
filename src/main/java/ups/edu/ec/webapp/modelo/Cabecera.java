package ups.edu.ec.webapp.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Cabecera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue
	private int ticketInt;
	private String numTicket;
	private Timestamp fechaEmision;
	private double costoTotal;
	private String estado;
	
	
	@ManyToOne
	private Vehiculo vehiculo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Detalle> detalles;

	public int getTicketInt() {
		return ticketInt;
	}

	public void setTicketInt(int ticketInt) {
		this.ticketInt = ticketInt;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public Timestamp getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	public void addDetalle(Detalle detalle) {
		if(detalles == null) {
			detalles = new ArrayList<Detalle>();
		}
		detalles.add(detalle);
		
	}

	@Override
	public String toString() {
		return "Cabecera [ticketInt=" + ticketInt + ", numTicket=" + numTicket + ", fechaEmision=" + fechaEmision
				+ ", costoTotal=" + costoTotal + ", estado=" + estado + ", vehiculo=" + vehiculo + ", detalles="
				+ detalles + "]";
	}


}
