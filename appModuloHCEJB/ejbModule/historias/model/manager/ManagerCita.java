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
	
	//Cita
	public List<Cita> findAllCita(){
		List<Cita> lista= em.createQuery("select o from Cita o").getResultList();
		return lista;
	}
	
	public List<Empleado> findAllEmpleado(){
		List<Empleado> lista = em.createQuery("select o from Empleado o").getResultList();
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
	
	public Cita actualizarCita(Cita cita, int id_Cita) {
		Cita c = (Cita)em.find(Cita.class, cita.getIdCita());
		c.setEmpleado(cita.getEmpleado());
		c.setFechaCita(cita.getFechaCita());
		em.merge(c);
		return c;
	}
}
