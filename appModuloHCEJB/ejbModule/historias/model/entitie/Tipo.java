package historias.model.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_IDTIPO_GENERATOR", sequenceName="SEQ_TIPO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_IDTIPO_GENERATOR")
	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="decripcion_tipo")
	private String decripcionTipo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	private List<Empleado> empleados;

	public Tipo() {
	}

	public Integer getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getDecripcionTipo() {
		return this.decripcionTipo;
	}

	public void setDecripcionTipo(String decripcionTipo) {
		this.decripcionTipo = decripcionTipo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setTipo(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setTipo(null);

		return empleado;
	}

}