package historias.model.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CITA_IDCITA_GENERATOR", sequenceName="SEQ_CITA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CITA_IDCITA_GENERATOR")
	@Column(name="id_cita")
	private Integer idCita;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cita")
	private Date fechaCita;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="ced_emple")
	private Empleado empleado;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="cita")
	private List<Consulta> consultas;

	public Cita() {
	}

	public Integer getIdCita() {
		return this.idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setCita(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setCita(null);

		return consulta;
	}

}