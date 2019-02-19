package historias.model.entitie;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the historias database table.
 * 
 */
@Entity
@Table(name="historias")
@NamedQuery(name="Historia.findAll", query="SELECT h FROM Historia h")
public class Historia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HISTORIAS_IDHIS_GENERATOR", sequenceName="SEQ_HISTORIAS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORIAS_IDHIS_GENERATOR")
	@Column(name="id_his")
	private Integer idHis;

	@Column(name="ante_alimenticios")
	private String anteAlimenticios;

	@Column(name="ante_familiares")
	private String anteFamiliares;

	@Column(name="ante_hospitalizaciones")
	private String anteHospitalizaciones;

	@Column(name="ante_patologicos")
	private String antePatologicos;

	@Column(name="ante_quirurgicos")
	private String anteQuirurgicos;

	@Column(name="ocupacion_his")
	private String ocupacionHis;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="ced_emple")
	private Empleado empleado;

	public Historia() {
	}

	public Integer getIdHis() {
		return this.idHis;
	}

	public void setIdHis(Integer idHis) {
		this.idHis = idHis;
	}

	public String getAnteAlimenticios() {
		return this.anteAlimenticios;
	}

	public void setAnteAlimenticios(String anteAlimenticios) {
		this.anteAlimenticios = anteAlimenticios;
	}

	public String getAnteFamiliares() {
		return this.anteFamiliares;
	}

	public void setAnteFamiliares(String anteFamiliares) {
		this.anteFamiliares = anteFamiliares;
	}

	public String getAnteHospitalizaciones() {
		return this.anteHospitalizaciones;
	}

	public void setAnteHospitalizaciones(String anteHospitalizaciones) {
		this.anteHospitalizaciones = anteHospitalizaciones;
	}

	public String getAntePatologicos() {
		return this.antePatologicos;
	}

	public void setAntePatologicos(String antePatologicos) {
		this.antePatologicos = antePatologicos;
	}

	public String getAnteQuirurgicos() {
		return this.anteQuirurgicos;
	}

	public void setAnteQuirurgicos(String anteQuirurgicos) {
		this.anteQuirurgicos = anteQuirurgicos;
	}

	public String getOcupacionHis() {
		return this.ocupacionHis;
	}

	public void setOcupacionHis(String ocupacionHis) {
		this.ocupacionHis = ocupacionHis;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}