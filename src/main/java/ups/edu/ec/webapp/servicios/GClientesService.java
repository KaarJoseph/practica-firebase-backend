package ups.edu.ec.webapp.servicios;

import java.sql.Connection;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.webapp.datos.PersonaDao;
import ups.edu.ec.webapp.modelo.Persona;
import ups.edu.ec.webapp.negocio.GestionClientes;

@Path("clientes")
public class GClientesService {
	
	@Inject
	private GestionClientes GClientes;
	
	@Inject
	private PersonaDao daoPersona;
	
	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}

	@GET
	@Path("Suma")
	public String suma(@QueryParam("a") int a,
			@QueryParam("b") int b) {
		
	return "R =" +(a+b);
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a") int a,
			@PathParam("b") int b) {
		
	return "R =" + (a * b);
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Persona misDatos() {
		Persona p = new Persona();
		p.setCedula("FFFFF");
		p.setNombre("XXXXX");
		p.setDireccion("ZZZZZ");
		return p;
	}
	
	@PersistenceContext
	private EntityManager entityManager;

    @GET
    @Path("personas")
    public String obtenerPersonas() {
        StringBuilder sb = new StringBuilder();

        List<Persona> personas = entityManager.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();

        for (Persona persona : personas) {
            String cedula = persona.getCedula();
            String nombre = persona.getNombre();
            String direccion = persona.getDireccion();

            sb.append("Cédula: ").append(cedula).append("\nNombre: ").append(nombre).append("\nDirección: ").append(direccion).append("\n\n");
        }

        return sb.toString();
    }
    
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			GClientes.guardarClientes(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersona() {
        List<Persona> listado = 
        		GClientes.getClientes();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
    
    
    @GET
    @Path("lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getListadoPersona(){
    	return daoPersona.getAll();
    }
    

    @DELETE
	@Path("eliminar")
	public String eliminar(@QueryParam("cedula") String cedula) {
		try {
			GClientes.eliminarCliente(cedula);
			return"elimina";
		} catch (Exception e) {

			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return "no";
		}
	}
    
    
    @DELETE
	@Path("elim/{cedula}")
	public String eliminar2(@PathParam("cedula") String cedula) {
		try {
			GClientes.eliminarCliente(cedula);
			return"elimina";
		} catch (Exception e) {

			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return "no";
		}
	}
    
 
}
