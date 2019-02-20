package historias.model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import historias.model.entitie.Empleado;
import historias.model.entitie.Tipo;

/**
 * Session Bean implementation class ManagerEmpleado
 */
@Stateless
@LocalBean
public class ManagerEmpleado {

	@PersistenceContext(unitName="historiaDS")
	private EntityManager m;
    /**
     * Default constructor. 
     */
    public ManagerEmpleado() {
        // TODO Auto-generated constructor stub
    }
    
    //Tipo empleado
    public List<Tipo> findAllTipo(){
    	List<Tipo> lista = m.createQuery("SELECT t FROM Tipo t").getResultList();
    	return lista;
    }
    
    public Tipo insertarTipo(Tipo tipo) {
    	Tipo t = new Tipo();
    	t.setDecripcionTipo(tipo.getDecripcionTipo());
    	m.persist(t);
    	return t;
    }
    
    //Empleado
    public List<Empleado> findAllEmpleado(){
    	List<Empleado> lista = m.createQuery("select o from Empleado o").getResultList();
    	return lista;
    }
    
    public Empleado insertarEmpleado(Empleado empleado, int id_tipo) {
    	Empleado e = new Empleado();
    	e.setNombreEmple(empleado.getNombreEmple());
    	e.setFechanaciEmple(empleado.getFechanaciEmple());
    	e.setTelefonoEmple(empleado.getTelefonoEmple());
    	e.setEmailEmple(empleado.getEmailEmple());
    	e.setPassEmple(empleado.getPassEmple());
    	Tipo t = (Tipo)m.find(Tipo.class, id_tipo);
    	e.setTipo(t);
    	m.persist(e);
    	return e;
    }
    
    public void eliminarPersona(String ced_emple) {
    	Empleado e =(Empleado) m.find(Empleado.class, ced_emple);
    	m.remove(e);
    }
    
    public Empleado actualizarEmpleado(Empleado empleado,int id_tipo) {
    	Empleado e = (Empleado) m.find(Empleado.class, empleado.getCedEmple());
    	e.setNombreEmple(empleado.getNombreEmple());
    	e.setFechanaciEmple(empleado.getFechanaciEmple());
    	e.setTelefonoEmple(empleado.getTelefonoEmple());
    	e.setEmailEmple(empleado.getEmailEmple());
    	e.setPassEmple(empleado.getPassEmple());
    	Tipo t = (Tipo)m.find(Tipo.class, id_tipo);
    	e.setTipo(t);
    	m.merge(e);
    	return e;
    }
    
    public Tipo agregarEmpleado(Tipo t, Empleado e) {
    	if(t==null) {
    		t= new Tipo();
    		t.setEmpleados(new ArrayList<Empleado>());
    	}
    	t.addEmpleado(e);
    	return t;
    }
    
    public Tipo guardarTipo(Tipo t) throws Exception {
    	if(t==null) {
    		throw new Exception("Debe ingresar datos");
    	}
    	if(t.getEmpleados().size()==0) {
    		throw new Exception("Debe tener valores");
    	}
    	m.persist(t);
    	return t;
    }

}
