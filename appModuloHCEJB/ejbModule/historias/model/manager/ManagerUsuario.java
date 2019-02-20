package historias.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import historias.model.entitie.Empleado;

/**
 * Session Bean implementation class ManagerUsuario
 */
@Stateless
@LocalBean
public class ManagerUsuario {

	@PersistenceContext(unitName="historiaDS")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerUsuario() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean comprobarUsuario(String ced_emple,String pass) throws Exception{
    	Empleado e = em.find(Empleado.class, ced_emple);
    	if(e==null)
    	{
    		throw new Exception("No existe el usuario "+ced_emple);
    	}
    	if(e.getPassEmple().equals(pass)) {
    		return true;
    	}else{
    		throw new Exception("Contraseña no válida.");
    	}
    }
}
