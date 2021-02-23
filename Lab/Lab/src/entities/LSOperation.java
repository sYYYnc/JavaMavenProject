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
@Table(name="LS_OPERATION")
public class LSOperation implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Operation_Id")
	private long OperationId;	
	
	//uni-directional many-to-one association to LSClientConfiguration
	@ManyToOne
	@JoinColumn(name="client_Config_Id")
	private LSClientConfiguration lsClientConfiguration;
	
	//uni-directional many-to-one association to LSClientConfiguration
	@ManyToOne
	@JoinColumn(name="receiver_Client_Config_Id")
	private LSClientConfiguration lsReceiverClientConfiguration;
	
	//uni-directional many-to-one association to LSTransactionType
	@ManyToOne
	@JoinColumn(name="transaction_Type_Id")
	private LSTransactionType lsTransactionType;
		
	//uni-directional many-to-one association to LSOperationStatus
	@ManyToOne
	@JoinColumn(name="operation_Status_Id")
	private LSOperationStatus lsOperationStatus;
	
	//uni-directional many-to-one association to LSAgentOperation
	@ManyToOne
	@JoinColumn(name="agent_Id")
	private LSAgent lsAgent;
	
	@Column
	private float value;
	
	@Column
	private float cost;
	
	@Column
	private LocalDateTime timestamp;
	
	@Column(name = "receiver_phone_number")
	private long receiverPhoneNumber;
	
	@Column(name = "pickup_Code")
	private String pickupCode;	
	
	@Column
	private float fee;
	
	@Column(name = "is_Fee_Payed")
	private String isFeePayed;
	
	public LSOperation() {
	}
	
	public long getOperation() {
		return OperationId;
	}

	public long getOperationId() {
		return OperationId;
	}

	public void setOperationId(long operationId) {
		OperationId = operationId;
	}

	public LSClientConfiguration getLsClientConfiguration() {
		return lsClientConfiguration;
	}

	public void setLsClientConfiguration(LSClientConfiguration lsClientConfiguration) {
		this.lsClientConfiguration = lsClientConfiguration;
	}

	public LSClientConfiguration getLsReceiverClientConfiguration() {
		return lsReceiverClientConfiguration;
	}

	public void setLsReceiverClientConfiguration(LSClientConfiguration lsReceiverClientConfiguration) {
		this.lsReceiverClientConfiguration = lsReceiverClientConfiguration;
	}

	public LSTransactionType getLsTransactionType() {
		return lsTransactionType;
	}

	public void setLsTransactionType(LSTransactionType lsTransactionType) {
		this.lsTransactionType = lsTransactionType;
	}

	public LSOperationStatus getLsOperationStatus() {
		return lsOperationStatus;
	}

	public void setLsOperationStatus(LSOperationStatus lsOperationStatus) {
		this.lsOperationStatus = lsOperationStatus;
	}

	public LSAgent getLsAgent() {
		return lsAgent;
	}

	public void setLsAgent(LSAgent lsAgent) {
		this.lsAgent = lsAgent;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public long getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}

	public void setReceiverPhoneNumber(long receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}

	public String getPickupCode() {
		return pickupCode;
	}

	public void setPickupCode(String pickupCode) {
		this.pickupCode = pickupCode;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public String getIsFeePayed() {
		return isFeePayed;
	}

	public void setIsFeePayed(String isFeePayed) {
		this.isFeePayed = isFeePayed;
	}
	
	
}