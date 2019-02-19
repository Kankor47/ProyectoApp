package historias.model.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the consulta database table.
 * 
 */
@Entity
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONSULTA_IDCON_GENERATOR", sequenceName="SEQ_CONSULTA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSULTA_IDCON_GENERATOR")
	@Column(name="id_con")
	private Integer idCon;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_con")
	private Date fechaCon;

	@Column(name="motivo_con")
	private String motivoCon;

	@Column(name="obervaciones_con")
	private String obervacionesCon;

	private BigDecimal peso;

	private String presion;

	@Column(name="temperatura_con")
	private BigDecimal temperaturaCon;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="id_cita")
	private Cita cita;

	//bi-directional many-to-one association to Receta
	@OneToMany(mappedBy="consulta")
	private List<Receta> recetas;

	public Consulta() {
	}

	public Integer getIdCon() {
		return this.idCon;
	}

	public void setIdCon(Integer idCon) {
		this.idCon = idCon;
	}

	public Date getFechaCon() {
		return this.fechaCon;
	}

	public void setFechaCon(Date fechaCon) {
		this.fechaCon = fechaCon;
	}

	public String getMotivoCon() {
		return this.motivoCon;
	}

	public void setMotivoCon(String motivoCon) {
		this.motivoCon = motivoCon;
	}

	public String getObervacionesCon() {
		return this.obervacionesCon;
	}

	public void setObervacionesCon(String obervacionesCon) {
		this.obervacionesCon = obervacionesCon;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getPresion() {
		return this.presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public BigDecimal getTemperaturaCon() {
		return this.temperaturaCon;
	}

	public void setTemperaturaCon(BigDecimal temperaturaCon) {
		this.temperaturaCon = temperaturaCon;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public List<Receta> getRecetas() {
		return this.recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public Receta addReceta(Receta receta) {
		getRecetas().add(receta);
		receta.setConsulta(this);

		return receta;
	}

	public Receta removeReceta(Receta receta) {
		getRecetas().remove(receta);
		receta.setConsulta(null);

		return receta;
	}

}