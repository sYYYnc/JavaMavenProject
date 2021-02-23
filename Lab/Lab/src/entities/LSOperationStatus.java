package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="LS_OPERATION_STATUS")
public class LSOperationStatus implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "operation_Status_Id")
	private long operationStatusId;	
	
	
	//uni-directional many-to-one association to LSStatusType
	@ManyToOne
	@JoinColumn(name="status_Type_Id")
	private LSStatusType lsStatusType;
		
	@Column
	private String description;	
	
	public LSOperationStatus() {
	}
	
	public long getOperationStatus() {
		return operationStatusId;
	}
	
	public LSStatusType getLsStatusType() {
		return lsStatusType;
	}

	public void setLSStatusType(LSStatusType lsStatusType) {
		this.lsStatusType = lsStatusType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}