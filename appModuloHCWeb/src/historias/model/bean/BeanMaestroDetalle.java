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
	private List<Empleado> listaEmpleado;
	private String ced_emple;
	private Cita cita;
	private List<Cita> listaCita;
	private Empleado empleado;
	
	@PostConstruct
	public void inicializar(){
		listaEmpleado = mc.findAllEmpleado();
		empleado = new Empleado();
		listaCita = mc.findAllCita();
		cita= new Cita();
		empleado.setCitas(new ArrayList<Cita>());
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
		ced_emple=cSeleccionado.getEmpleado().getCedEmple();
	}
	
	public void actionListenerActualizar() {
		mc.actualizarCita(cita, ced_emple);
		listaCita=mc.findAllCita();
		cita= new Cita();
	}
	
	public void actionListenerRecargarCita() {
		listaEmpleado=mc.findAllEmpleado();
	}
	
	public void actionListenerAgregarCita() {
		empleado=mc.agregarCita(empleado,cita);
		cita=new Cita();
	}
	
	public void actionListenerGuardartransaccion() {
		try {
			empleado=mc.guardarEmpleado(empleado);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "transaccion completa",null));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),null));
			e.printStackTrace();
		}
	}
	
	public void actionListenerNuevoEmpleado()
	{
		empleado = new Empleado();
		empleado.setCitas(new ArrayList<Cita>());
		cita = new Cita();
	}
}
