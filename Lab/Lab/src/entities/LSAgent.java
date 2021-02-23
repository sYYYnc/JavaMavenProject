package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="LS_AGENT")
public class LSAgent implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "agent_Id")
	private long agentId;
	
	//uni-directional many-to-one association to LSClientStatus
	@ManyToOne
	@JoinColumn(name="agent_Status_Id")
	private LSAgentStatus lsAgentStatus;	
	
	@Column(name = "management_Balance")
	private float managementBalance;	
	
	@Column(name = "creation_Timestamp")
	private LocalDateTime creationTimestamp;
	
	@Column
	private String name;

	@Column
	private long nif;
	
	
	public LSAgent() {
	}
	
	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getNIF() {
		return nif;
	}

	public void setNIF(long nif) {
		this.nif = nif;
	}

	public LSAgentStatus getLsAgentStatus() {
		return lsAgentStatus;
	}

	public void setLsAgentStatus(LSAgentStatus lsAgentStatus) {
		this.lsAgentStatus = lsAgentStatus;
	}

	public float getManagementBalance() {
		return managementBalance;
	}

	public void setManagementBalance(float managementBalance) {
		this.managementBalance = managementBalance;
	}

	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
}