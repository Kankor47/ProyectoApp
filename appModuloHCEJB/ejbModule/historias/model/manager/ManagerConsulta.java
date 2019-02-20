package historias.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import historias.model.entitie.Consulta;

/**
 * Session Bean implementation class ManagerConsulta
 */
@Stateless
@LocalBean
public class ManagerConsulta {

    @PersistenceContext(unitName = "historia")
    private EntityManager em;
    public ManagerConsulta() {
        // TODO Auto-generated constructor stub
    }
    public List<Consulta> findAllConsulta(){
    	List<Consulta> lista=em.createQuery("SELECT c FROM Consulta c").getResultList();
    	return lista;
    }
    public Consulta insertarConsulta(Consulta ConsultaNueva) {
    	Consulta cn=new Consulta();
    	cn.setIdCon(ConsultaNueva.getIdCon());
    	cn.setCita(ConsultaNueva.getCita());
    	cn.setFechaCon(ConsultaNueva.getFechaCon());
    	cn.setMotivoCon(ConsultaNueva.getMotivoCon());
    	cn.setObervacionesCon(ConsultaNueva.getObervacionesCon());
    	cn.setPeso(ConsultaNueva.getPeso());
    	cn.setPresion(ConsultaNueva.getPresion());
    	cn.setTemperaturaCon(ConsultaNueva.getTemperaturaCon());
    	
    	em.persist(cn);
    	return cn;
    }
    public void eliminarConsulta(int IdCon) {
    	Consulta cn=(Consulta)em.find(Consulta.class, IdCon);
    	em.remove(cn);
    }
    public Consulta actualizarConsulta(Consulta consulta,int IdCon) {
    	Consulta cnActual=(Consulta)em.find(Consulta.class, consulta.getIdCon());
    	cnActual.setIdCon(consulta.getIdCon());
    	cnActual.setCita(consulta.getCita());
    	cnActual.setFechaCon(consulta.getFechaCon());
    	cnActual.setMotivoCon(consulta.getMotivoCon());
    	cnActual.setObervacionesCon(consulta.getObervacionesCon());
    	cnActual.setPeso(consulta.getPeso());
    	cnActual.setPresion(consulta.getPresion());
    	cnActual.setTemperaturaCon(consulta.getTemperaturaCon());
    	em.merge(cnActual);
    	return cnActual;
    }

}
