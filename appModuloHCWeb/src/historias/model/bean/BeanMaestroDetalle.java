package historias.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import historias.model.entitie.Cita;
import historias.model.entitie.Empleado;
import historias.model.manager.ManagerCita;

@ManagedBean
@SessionScoped
public class BeanMaestroDetalle {

	@EJB
	private ManagerCita mc;
	private int id_cita;
	private Cita cita;
	private List<Cita> listaCita;
	private String ced_emple;
	private List<Empleado> listaEmpleado;
	private Empleado empleado;
	
	@PostConstruct
	public void inicializar(){
		listaEmpleado=mc.findAllEmpleado();
		listaCita = mc.findAllCita();
		cita= new Cita();
		empleado = new Empleado();
	}
	
	public void actionListenereInsertarCita() {
		mc.insertarCita(cita, ced_emple);
		cita = new Cita();
		listaCita=mc.findAllCita();
	}
	
	public void actionListenerEliminarCita(Cita c) {
		mc.eliminarCita(cita.getIdCita());
		listaCita=mc.findAllCita();
	}
	
	public void actionListenerSeleccionarCita(Cita cSeleccionado) {
		cita=cSeleccionado;
		id_cita=cSeleccionado.getIdCita();
	}
	
	public void actionListenerActualizar() {
		mc.actualizarCita(cita, id_cita);
		listaCita=mc.findAllCita();
		cita = new Cita();
	}

	public int getId_cita() {
		return id_cita;
	}

	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public List<Cita> getListaCita() {
		return listaCita;
	}

	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
	}

	public String getCed_emple() {
		return ced_emple;
	}

	public void setCed_emple(String ced_emple) {
		this.ced_emple = ced_emple;
	}

	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}

	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
