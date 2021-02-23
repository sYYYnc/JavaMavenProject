package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LS_AGENT_STATUS")
public class LSAgentStatus implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "agent_Status_Id")
	private long agentStatusId;
	
	@Column
	private String description;

	public LSAgentStatus() {
	}
	
	public long getAgentStatusId() {
		return agentStatusId;
	}

	public void setAgentStatusId(long agentStatusId) {
		this.agentStatusId = agentStatusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}