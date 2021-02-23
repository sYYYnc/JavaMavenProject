package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LS_CONTESTATION_STATUS")
public class LSContestationStatus implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contestation_Status_Id")
	private long contestationStatusId;
	
	@Column
	private String description;

	public LSContestationStatus() {
	}
	
	public long getContestationStatusId() {
		return contestationStatusId;
	}

	public void setContestationStatusId(long contestationStatusId) {
		this.contestationStatusId = contestationStatusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}