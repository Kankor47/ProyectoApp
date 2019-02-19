package historias.model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import historias.model.entitie.Cita;
import historias.model.entitie.Empleado;

/**
 * Session Bean implementation class ManagerCita
 */
@Stateless
@LocalBean
public class ManagerCita {
	@PersistenceContext(unitName="historiaDS")
	private EntityManager em;
	
	public ManagerCita() {
        // TODO Auto-generated constructor stub
    }
	
	//Empleado
	public List<Empleado> findAllEmpleado(){
    	List<Empleado> lista=em.createQuery("select o from Empleado o").getResultList();
    	return lista;
    }
	
	public Empleado insertarCita(Empleado empleado)
	{
		Empleado e  = new Empleado();
		e.setCedEmple(empleado.getCedEmple());
		e.setTipo(empleado.getTipo());
		e.setNombreEmple(empleado.getNombreEmple());
		e.setFechanaciEmple(empleado.getFechanaciEmple());
		e.setTelefonoEmple(empleado.getTelefonoEmple());
		e.setEmailEmple(empleado.getEmailEmple());
		e.setPassEmple(empleado.getPassEmple());
		em.persist(e);
		return e;
	}
	
	//Cita
	public List<Cita> findAllCita(){
		List<Cita> lista= em.createQuery("select o from Cita o").getResultList();
		return lista;
	}
	
	public Cita insertarCita(Cita cita, String ced_emple) {
		Cita c = new Cita();
		c.setFechaCita(cita.getFechaCita());
		Empleado e = (Empleado)em.find(Empleado.class, ced_emple);
		c.setEmpleado(e);
		em.persist(c);
		return c;
	}
	
	public void eliminarCita(int id_cita) {
		Cita c =(Cita)em.find(Cita.class, id_cita);
		em.remove(c);
	}
	
	public Cita actualizarCita(Cita cita, String ced_emple) {
		Cita c = (Cita)em.find(Cita.class, cita.getIdCita());
		c.setFechaCita(cita.getFechaCita());
		Empleado e =(Empleado)em.find(Empleado.class, ced_emple);
		c.setEmpleado(e);
		em.merge(c);
		return c;
	}
	
	//agregar
	public Empleado agregarCita(Empleado empleado, Cita cita) {
		if(empleado==null)
		{
			empleado = new Empleado();
			empleado.setCitas(new ArrayList<Cita>());
		}
		empleado.addCita(cita);
		return empleado;
	}
    
    //guardar tabla
	public Empleado guardarEmpleado(Empleado empleado) throws Exception{
		if(empleado == null) {
			throw new Exception("Debe primero crear valores");
		}
		if(empleado.getCitas().size()==0) {
			throw new Exception("Debe tener valores");
		}
		em.persist(empleado);
		return empleado;
	}

}
