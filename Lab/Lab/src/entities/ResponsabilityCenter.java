package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESPONSABILITYCENTER database table.
 * 
 */
@Entity
@NamedQuery(name="ResponsabilityCenter.findAll", query="SELECT r FROM ResponsabilityCenter r")
public class ResponsabilityCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPONSABILITYCENTER_ID_GENERATOR", sequenceName="RESPONSABILITYCENTER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPONSABILITYCENTER_ID_GENERATOR")
	private long id;
	
	private String descricao;

	private String siglas;

	public ResponsabilityCenter() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSiglas() {
		return this.siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
}