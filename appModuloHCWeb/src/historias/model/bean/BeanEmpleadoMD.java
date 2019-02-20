package historias.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import historias.model.entitie.Empleado;
import historias.model.entitie.Tipo;
import historias.model.manager.ManagerEmpleado;

@ManagedBean
@SessionScoped
public class BeanEmpleadoMD {

	@EJB
	private ManagerEmpleado me;
	private List<Tipo> listaTipo;
	private int id_tipo;
	private Empleado e;
	private List<Empleado> listaEmpleado;
	private Tipo t;
	
	@PostConstruct
	public void inicializar() {
		listaTipo=me.findAllTipo();
		e =  new Empleado();
		listaEmpleado=me.findAllEmpleado();
		t=new Tipo();
		t.setEmpleados(new ArrayList<Empleado>());
	}
	
	public void actionListenerInsertarEmpleado() {
		me.insertarEmpleado(e, id_tipo);
		e = new Empleado();
		listaEmpleado=me.findAllEmpleado();
	}
	
	public void actionListenerElminarEmpleado(Empleado empleado) {
		me.eliminarPersona(empleado.getCedEmple());
		listaEmpleado=me.findAllEmpleado();
	}
	
	public void actionListenerSeleccionarEmpleado(Empleado eSeleccionado) {
		e = eSeleccionado;
		id_tipo=eSeleccionado.getTipo().getIdTipo();
	}
	
	public void actionListenerActualizar() {
		me.actualizarEmpleado(e, id_tipo);
		listaEmpleado=me.findAllEmpleado();
		e=new Empleado();
	}
	
	public void actionListenerRecargarTipo() {
		listaTipo=me.findAllTipo();
	}
	
	public void actionListenerAgregarDetalle() {
		t = me.agregarEmpleado(t, e);
		e = new Empleado();
	}
	
	public void actionListenerGuardarTransaccion() {
		try {
			t=me.guardarTipo(t);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "transaccion completa",null));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),null));
			e.printStackTrace();
		}
	}
	
	public void actionsListenerNuevoTipo() {
		t= new Tipo();
		t.setEmpleados(new ArrayList<Empleado>());
		e = new Empleado();
	}

	
	//get && set
	public List<Tipo> getListaTipo() {
		return listaTipo;
	}

	public void setListaTipo(List<Tipo> listaTipo) {
		this.listaTipo = listaTipo;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Empleado getE() {
		return e;
	}

	public void setE(Empleado e) {
		this.e = e;
	}

	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}

	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	public Tipo getT() {
		return t;
	}

	public void setT(Tipo t) {
		this.t = t;
	}
}
