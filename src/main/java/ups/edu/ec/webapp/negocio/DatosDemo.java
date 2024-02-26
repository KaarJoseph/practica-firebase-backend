package ups.edu.ec.webapp.negocio;

import java.sql.Timestamp;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.webapp.modelo.Cabecera;
import ups.edu.ec.webapp.modelo.Detalle;
import ups.edu.ec.webapp.modelo.Espacio;
import ups.edu.ec.webapp.modelo.Persona;
import ups.edu.ec.webapp.modelo.Vehiculo;
import ups.edu.ec.webapp.datos.CabeceraDao;
import ups.edu.ec.webapp.datos.DetalleDao;
import ups.edu.ec.webapp.datos.EspacioDao;
import ups.edu.ec.webapp.datos.PersonaDao;
import ups.edu.ec.webapp.datos.VehiculoDao;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private PersonaDao daoPersona;
	
	@Inject
	private VehiculoDao daoVehiculo;

	@Inject
	private EspacioDao daoEspacio;
	
	@Inject
	private DetalleDao daoDetalle;
	
	@Inject
	private CabeceraDao daoCabecera;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Hola UPS");
		
		Persona p = new Persona();
		p.setCedula("01");
		p.setDireccion("Rio Cenepa");
		p.setNombre("Joseph");
		daoPersona.insert(p);

        System.out.println("Persona2");

        Persona p2 = new Persona();
		p2.setCedula("02");
		p2.setDireccion("Rio Palora");
		p2.setNombre("Kaar");
        daoPersona.insert(p2);

        System.out.println("Persona3");

        Persona p3 = new Persona();
		p3.setCedula("03");
		p3.setDireccion("Hurtado Mendoza");
		p3.setNombre("Kaar Joseph");
        daoPersona.insert(p3);
        daoPersona.imprimirDatos();
        
        System.out.println("*** ESPACIO ***");
        
        Espacio e = new Espacio();
        e.setEspacioId(01);
        e.setNumEspacio(01);
        e.setEstado("Ocupado");
        e.setCosto(0.50);
		daoEspacio.insert(e);;
		daoEspacio.imprimirDatos();
        
        System.out.println("*** VEHICULO ***");
		
	    Vehiculo v = new Vehiculo();
		v.setVehiculoId(01);
		v.setPlaca("ABC-123");
		v.setMarca("KIA");
		v.setModelo("Rio");
		v.setTipo("Camioneta");
		Persona persona = daoPersona.read("01"); 
		//v.setPersona(persona);
		daoVehiculo.insert(v);
        daoVehiculo.imprimirDatos();
		
		
        System.out.println("*** CABECERA ***");

		Cabecera c = new Cabecera();
		c.setTicketInt(01);
		c.setNumTicket("12345");
		c.setFechaEmision(Timestamp.valueOf("2023-07-01 10:29:00"));
		c.setCostoTotal(5.00);
		c.setEstado("Activo");
		Persona personaCab= daoPersona.read("03"); 
		//c.setPersona(personaCab);
		Vehiculo vehiculo= daoVehiculo.read(01); 
		c.setVehiculo(vehiculo);
		daoCabecera.insert(c);
		//c.addDetalle(d1);
		//daoEspacio.imprimirDatos();
		
        System.out.println("*** DETALLE ***");
		
		Detalle d = new Detalle();
		d.setDetalleId(01);
		d.setFechaIngreso(Timestamp.valueOf("2023-07-01 10:30:00"));
		d.setFechaSalida(Timestamp.valueOf("2023-07-01 20:30:00"));
		d.setCosto(5.00);
		Espacio espacio= daoEspacio.read(01); 
		d.setEspacio(espacio);
		Cabecera cabecera= daoCabecera.read(01); 
		d.setCabecera(cabecera);
		daoDetalle.insert(d);
		
		c.addDetalle(d); // Mover aquí la llamada al método addDetalle()

		//daoDetalle.imprimirDatos();

		
        System.out.println("*** IMPRESIÓN FACTURA ***");
       	
		List<Detalle> detalles = daoDetalle.getAll();
		for(Detalle de: detalles) {
			System.out.println(de);
		}
		
		/*List<Cabecera> cabeceras = daoCabecera.getAll();
		for(Cabecera cab: cabeceras) {  
			System.out.println("*** FACTURA-TICKET ***\n");
			Persona personaDueño = cab.getVehiculo().getPersona();

			System.out.println("Id de ticket: " + cab.getTicketInt() + ", Numero de ticket: " + cab.getNumTicket() +
			        ", fechaEmisión: " + cab.getFechaEmision() + ", total a pagar: " + cab.getCostoTotal() +
			        ", estado: " + cab.getEstado() + ", Empleado: " + cab.getPersona().getNombre() +
			        "\nVehiculo: " + cab.getVehiculo());
		}*/
	}
}