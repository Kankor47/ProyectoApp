package historias.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import historias.model.entitie.Historia;

/**
 * Session Bean implementation class ManagerHistorias
 */
@Stateless
@LocalBean
public class ManagerHistorias {
	@PersistenceContext(unitName = "historia")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerHistorias() {
        // TODO Auto-generated constructor stub
    }
    public List<Historia> findAllHistoria(){
    	List<Historia> lista=em.createQuery("SELECT h FROM Historia h").getResultList();
    	return lista;
    }
    public Historia insertarHistoria(Historia HistoriaNueva) {
    	Historia hc=new Historia();
    	hc.setIdHis(HistoriaNueva.getIdHis());
    	hc.setEmpleado(HistoriaNueva.getEmpleado());
    	hc.setOcupacionHis(HistoriaNueva.getOcupacionHis());
    	hc.setAnteAlimenticios(HistoriaNueva.getAnteAlimenticios());
    	hc.setAnteFamiliares(HistoriaNueva.getAnteFamiliares());
    	hc.setAnteHospitalizaciones(HistoriaNueva.getAnteHospitalizaciones());
    	hc.setAntePatologicos(HistoriaNueva.getAntePatologicos());
    	hc.setAnteQuirurgicos(HistoriaNueva.getAnteQuirurgicos());
    	em.persist(hc);
    	return hc;
    }
    public void eliminarHistoria(int IdHis) {
    	Historia hc=(Historia)em.find(Historia.class, IdHis);
    	em.remove(hc);
    }
    public Historia actualizarHistoria(Historia historia,int IdHis){
    	Historia hcActual=(Historia)em.find(Historia.class, historia.getIdHis());
    	hcActual.setIdHis(historia.getIdHis());
    	hcActual.setEmpleado(historia.getEmpleado());
    	hcActual.setOcupacionHis(historia.getOcupacionHis());
    	hcActual.setAnteAlimenticios(historia.getAnteAlimenticios());
    	hcActual.setAnteFamiliares(historia.getAnteFamiliares());
    	hcActual.setAnteHospitalizaciones(historia.getAnteHospitalizaciones());
    	hcActual.setAntePatologicos(historia.getAntePatologicos());
    	hcActual.setAnteQuirurgicos(historia.getAnteQuirurgicos());
    	em.merge(hcActual);
    	return hcActual;

    	}

}
