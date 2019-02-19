package historias.model.entitie;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the receta database table.
 * 
 */
@Entity
@NamedQuery(name="Receta.findAll", query="SELECT r FROM Receta r")
public class Receta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECETA_IDRECE_GENERATOR", sequenceName="SEQ_RECETA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECETA_IDRECE_GENERATOR")
	@Column(name="id_rece")
	private Integer idRece;

	@Column(name="indicaciones_con")
	private String indicacionesCon;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="id_con")
	private Consulta consulta;

	public Receta() {
	}

	public Integer getIdRece() {
		return this.idRece;
	}

	public void setIdRece(Integer idRece) {
		this.idRece = idRece;
	}

	public String getIndicacionesCon() {
		return this.indicacionesCon;
	}

	public void setIndicacionesCon(String indicacionesCon) {
		this.indicacionesCon = indicacionesCon;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}