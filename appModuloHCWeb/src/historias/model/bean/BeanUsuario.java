package historias.model.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import historias.model.entitie.Empleado;
import historias.model.manager.ManagerUsuario;

@ManagedBean
@SessionScoped
public class BeanUsuario {

	
	@EJB
	private ManagerUsuario managerUsuarios;
	
	private Empleado e;
	private String idUsuario;
	private String clave;
	
	public void inicializar() {
		e = new Empleado();
	}

	public String actionLogin() {
		try {
			boolean respuesta = managerUsuarios.comprobarUsuario(idUsuario, clave);
			// verificamos si el acceso es con admin:
			if(e.getTipo().getDecripcionTipo().equals("Administrador")) {
				return "Administrador/index";
			}
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public Empleado getE() {
		return e;
	}

	public void setE(Empleado e) {
		this.e = e;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
