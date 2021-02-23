package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LS_CLIENT_STATUS")
public class LSClientStatus implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "client_Status_Id")
	private long clientStatusId;
	
	@Column
	private String description;

	public LSClientStatus() {
	}
	
	public long getClientStatusId() {
		return clientStatusId;
	}

	public void setClientStatusId(long clientStatusId) {
		this.clientStatusId = clientStatusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}