package historias.model.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLEADO_CEDEMPLE_GENERATOR", sequenceName="SEQ_EMPLEADO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLEADO_CEDEMPLE_GENERATOR")
	@Column(name="ced_emple")
	private String cedEmple;

	@Column(name="email_emple")
	private String emailEmple;

	@Temporal(TemporalType.DATE)
	@Column(name="fechanaci_emple")
	private Date fechanaciEmple;

	@Column(name="nombre_emple")
	private String nombreEmple;

	@Column(name="pass_emple")
	private String passEmple;

	@Column(name="telefono_emple")
	private String telefonoEmple;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="empleado", cascade=CascadeType.ALL)
	private List<Cita> citas;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private Tipo tipo;

	//bi-directional many-to-one association to Historia
	@OneToMany(mappedBy="empleado")
	private List<Historia> historias;

	public Empleado() {
	}

	public String getCedEmple() {
		return this.cedEmple;
	}

	public void setCedEmple(String cedEmple) {
		this.cedEmple = cedEmple;
	}

	public String getEmailEmple() {
		return this.emailEmple;
	}

	public void setEmailEmple(String emailEmple) {
		this.emailEmple = emailEmple;
	}

	public Date getFechanaciEmple() {
		return this.fechanaciEmple;
	}

	public void setFechanaciEmple(Date fechanaciEmple) {
		this.fechanaciEmple = fechanaciEmple;
	}

	public String getNombreEmple() {
		return this.nombreEmple;
	}

	public void setNombreEmple(String nombreEmple) {
		this.nombreEmple = nombreEmple;
	}

	public String getPassEmple() {
		return this.passEmple;
	}

	public void setPassEmple(String passEmple) {
		this.passEmple = passEmple;
	}

	public String getTelefonoEmple() {
		return this.telefonoEmple;
	}

	public void setTelefonoEmple(String telefonoEmple) {
		this.telefonoEmple = telefonoEmple;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setEmpleado(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setEmpleado(null);

		return cita;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Historia> getHistorias() {
		return this.historias;
	}

	public void setHistorias(List<Historia> historias) {
		this.historias = historias;
	}

	public Historia addHistoria(Historia historia) {
		getHistorias().add(historia);
		historia.setEmpleado(this);

		return historia;
	}

	public Historia removeHistoria(Historia historia) {
		getHistorias().remove(historia);
		historia.setEmpleado(null);

		return historia;
	}

}