package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LS_TRANSACTION_TYPE")
public class LSTransactionType implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "transaction_Type_Id")
	private long transactionTypeId;
	
	@Column
	private String description;

	public LSTransactionType() {
	}
	
	public long getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}