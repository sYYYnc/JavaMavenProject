package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COLABORADORES database table.
 * 
 */
@Entity
@NamedQuery(name="Colaboradores.findAll", query="SELECT c FROM Colaboradores c")
public class Colaboradores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COLABORADORES_ID_GENERATOR", sequenceName="COLABORADORES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLABORADORES_ID_GENERATOR")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCIMENTO")
	private Date dataNascimento;
	
	private String nome;

	private long vencimento;

	//bi-directional many-to-one association to ResponsabilityCenter
	@ManyToOne
	@JoinColumn(name="ID_RC")
	private ResponsabilityCenter rc;

	public Colaboradores() {
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(long vencimento) {
		this.vencimento = vencimento;
	}

	public ResponsabilityCenter getRc() {
		return this.rc;
	}

	public void setRc(ResponsabilityCenter rc) {
		this.rc = rc;
	}

}