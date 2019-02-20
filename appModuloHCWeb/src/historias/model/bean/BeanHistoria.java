package historias.model.bean;
import historias.model.manager.ManagerHistorias;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import historias.model.entitie.Historia;
@ManagedBean
@SessionScoped
public class BeanHistoria {
	@EJB
	private ManagerHistorias mHistoria;
	private List<Historia> listaHistoria;
	private int idHis;
	private Historia historia;
	
	@PostConstruct
	public void inicializar() {
		listaHistoria=mHistoria.findAllHistoria();
		historia=new Historia();
		
	}
	public void actionListenerInsertarHistoria() {
		mHistoria.insertarHistoria(historia);
		historia=new Historia();
		listaHistoria=mHistoria.findAllHistoria();
	}
	public void actionListenerEliminarHistoria(Historia historia) {
		mHistoria.eliminarHistoria(historia.getIdHis());
		listaHistoria=mHistoria.findAllHistoria();
	}
	public void actionListenerActualizar() {
		mHistoria.actualizarHistoria(historia, idHis);
		listaHistoria=mHistoria.findAllHistoria();
		historia=new Historia();
	}
	public void actionListenerSeleccionarHistoria(Historia historiaSeleccionada) {
		historia=historiaSeleccionada;
		idHis=historiaSeleccionada.getIdHis();
	}
	public void actionListenerRecargarHistoria() {
		listaHistoria=mHistoria.findAllHistoria();
	}
	public ManagerHistorias getmHistoria() {
		return mHistoria;
	}
	public void setmHistoria(ManagerHistorias mHistoria) {
		this.mHistoria = mHistoria;
	}
	public List<Historia> getListaHistoria() {
		return listaHistoria;
	}
	public void setListaHistoria(List<Historia> listaHistoria) {
		this.listaHistoria = listaHistoria;
	}
	public int getIdHis() {
		return idHis;
	}
	public void setIdHis(int idHis) {
		this.idHis = idHis;
	}
	public Historia getHistoria() {
		return historia;
	}
	public void setHistoria(Historia historia) {
		this.historia = historia;
	}
	
}
