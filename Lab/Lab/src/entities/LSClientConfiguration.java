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
@Table(name="LS_CLIENT_CONFIGURATION")
public class LSClientConfiguration implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "client_Configuration_Id")
	private long clientConfigurationId;	
	
	@Column(name = "phone_number")
	private long phoneNumber;
	
	//uni-directional many-to-one association to LSClient
	@ManyToOne
	@JoinColumn(name="client_Id")
	private LSClient lsClient;
		
	//uni-directional many-to-one association to LSClientStatus
	@ManyToOne
	@JoinColumn(name="client_Status_Id")
	private LSClientStatus lsClientStatus;	
	
	@Column
	private float balance;	
	
	@Column(name = "creation_Timestamp")
	private LocalDateTime creationTimestamp;	
	
	public LSClientConfiguration() {
	}

	public long getClientConfigurationId() {
		return clientConfigurationId;
	}

	public void setClientConfigurationId(long clientConfigurationId) {
		this.clientConfigurationId = clientConfigurationId;
	}

	public LSClient getLsClient() {
		return lsClient;
	}

	public void setLsClient(LSClient lsClient) {
		this.lsClient = lsClient;
	}

	public LSClientStatus getLsClientStatus() {
		return lsClientStatus;
	}

	public void setLsClientStatus(LSClientStatus lsClientStatus) {
		this.lsClientStatus = lsClientStatus;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}