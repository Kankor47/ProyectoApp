package historias.model.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import historias.model.manager.ManagerReceta;
import historias.model.entitie.Receta;
@ManagedBean
@SessionScoped
public class BeanReceta {
	@EJB
	private ManagerReceta mReceta;
	private List<Receta> listaReceta;
	private int idRece;
	private Receta receta;
	
	@PostConstruct
	public void inicializar() {
		listaReceta=mReceta.findAllReceta();
		receta=new Receta();
		
	}
	public void actionListenerInsertarReceta() {
		mReceta.insertarReceta(receta);
		receta=new Receta();
		listaReceta=mReceta.findAllReceta();
	}
	public void actionListenerEliminarReceta(Receta receta) {
		mReceta.eliminarReceta(receta.getIdRece());
		listaReceta=mReceta.findAllReceta();
	}
	
	public void actionListenerActualizar() {
		mReceta.actualizarReceta(receta, idRece);
		listaReceta=mReceta.findAllReceta();
		receta=new Receta();
	}
	public void actionListenerSeleccionarReceta(Receta recetaSeleccionada) {
		receta=recetaSeleccionada;
		idRece=recetaSeleccionada.getIdRece();
	}
	public void actionListenerRecargarReceta() {
		listaReceta=mReceta.findAllReceta();
	}
	public ManagerReceta getmReceta() {
		return mReceta;
	}
	public void setmReceta(ManagerReceta mReceta) {
		this.mReceta = mReceta;
	}
	public List<Receta> getListaReceta() {
		return listaReceta;
	}
	public void setListaReceta(List<Receta> listaReceta) {
		this.listaReceta = listaReceta;
	}
	public int getIdRece() {
		return idRece;
	}
	public void setIdRece(int idRece) {
		this.idRece = idRece;
	}
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
}
