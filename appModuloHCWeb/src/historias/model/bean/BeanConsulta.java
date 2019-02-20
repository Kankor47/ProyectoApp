package historias.model.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import historias.model.manager.ManagerConsulta;
import historias.model.entitie.Consulta;
@ManagedBean
@SessionScoped
public class BeanConsulta {
	
	@EJB
	private ManagerConsulta mConsulta;
	private List<Consulta> listaConsulta;
	private int idCon;
	private Consulta consulta;
	
	@PostConstruct
	public void inicializar() {
		listaConsulta=mConsulta.findAllConsulta();
		consulta=new Consulta();
		
	}
	public void actionListenerInsertarConsulta() {
		mConsulta.insertarConsulta(consulta);
		consulta=new Consulta();
		listaConsulta=mConsulta.findAllConsulta();
	}
	public void actionListenerEliminarConsulta(Consulta consulta) {
		mConsulta.eliminarConsulta(consulta.getIdCon());
		listaConsulta=mConsulta.findAllConsulta();
	}

	public void actionListenerActualizar() {
		mConsulta.actualizarConsulta(consulta, idCon);
		listaConsulta=mConsulta.findAllConsulta();
		consulta=new Consulta();
	}
	
	public void actionListenerSeleccionarConsulta(Consulta consultaSeleccionada) {
		consulta=consultaSeleccionada;
		idCon=consultaSeleccionada.getIdCon();
	}
	public void actionListenerRecargarConsulta() {
		listaConsulta=mConsulta.findAllConsulta();
	}
	
	public ManagerConsulta getmConsulta() {
		return mConsulta;
	}
	public void setmConsulta(ManagerConsulta mConsulta) {
		this.mConsulta = mConsulta;
	}
	public List<Consulta> getListaConsulta() {
		return listaConsulta;
	}
	public void setListaConsulta(List<Consulta> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}
	public int getIdCon() {
		return idCon;
	}
	public void setIdCon(int idCon) {
		this.idCon = idCon;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	
	}

