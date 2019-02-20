package historias.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import historias.model.entitie.Receta;
/**
 * Session Bean implementation class ManagerReceta
 */
@Stateless
@LocalBean
public class ManagerReceta {

	@PersistenceContext(unitName = "historia")
	private EntityManager em;
    public ManagerReceta() {
        // TODO Auto-generated constructor stub
    }
    public List<Receta> findAllReceta(){
    	List<Receta> lista=em.createQuery("Select r from Receta r").getResultList();
    return lista;
    }
    
    public Receta insertarReceta(Receta RecetaNueva) {
    	Receta rc=new Receta();
    	rc.setIdRece(RecetaNueva.getIdRece());
    	rc.setConsulta(RecetaNueva.getConsulta());
    	rc.setIndicacionesCon(RecetaNueva.getIndicacionesCon());
    	em.persist(rc);
    	return rc;
    }
    public void eliminarReceta(int IdRece) {
    	Receta rc=(Receta)em.find(Receta.class, IdRece);
    	em.remove(rc);
    }
    public Receta actualizarReceta(Receta receta,int IdRece) {
    	Receta rcActual=(Receta)em.find(Receta.class, receta.getClass());
    	rcActual.setIdRece(receta.getIdRece());
    	rcActual.setConsulta(receta.getConsulta());
    	rcActual.setIndicacionesCon(receta.getIndicacionesCon());
    	em.merge(rcActual);
    	return rcActual;
    }
}
