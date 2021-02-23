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
@Table(name="LS_CONTESTATION")
public class LSContestation implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contestation_Id")
	private long contestationId;	
	
	
	//uni-directional many-to-one association to LSAgentOperation
	@ManyToOne
	@JoinColumn(name="Operation_Id")
	private LSOperation lsOperation;
		
	//uni-directional many-to-one association to LSContestationStatus
	@ManyToOne
	@JoinColumn(name="contestation_Status_Id")
	private LSContestationStatus lsContestationStatus;	
	
	@Column(name = "dispute_Message")
	private String disputeMessage;
	
	@Column(name = "resolved_Message")
	private String resolvedMessage;	
	
	public LSContestation() {
	}
	
	public long getContestation() {
		return contestationId;
	}

	public LSContestationStatus getLSContestationStatus() {
		return this.lsContestationStatus;
	}

	public void setLSContestationStatus(LSContestationStatus lsContestationStatus) {
		this.lsContestationStatus = lsContestationStatus;
	}	
	
	public LSOperation getLsOperation() {
		return lsOperation;
	}

	public void setLsOperation(LSOperation lsOperation) {
		this.lsOperation = lsOperation;
	}

	public String getDisputeMessage() {
		return this.disputeMessage;
	}

	public void setDisputeMessage(String disputeMessage) {
		this.disputeMessage = disputeMessage;
	}
	
	public String getResolvedMessage() {
		return this.resolvedMessage;
	}

	public void setResolvedMessage(String resolvedMessage) {
		this.resolvedMessage = resolvedMessage;
	}
}