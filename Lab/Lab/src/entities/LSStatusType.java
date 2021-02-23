package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LS_STATUS_TYPE")
public class LSStatusType implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "status_Type_Id")
	private long statusTypeId;
	
	@Column
	private String description;

	public LSStatusType() {
	}
	
	public long getStatusTypeId() {
		return statusTypeId;
	}

	public void setStatusTypeId(long statusTypeId) {
		this.statusTypeId = statusTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}