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
@Table(name="LS_MESSAGE")
public class LSMessage implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "message_Id")
	private long messageId;	
	
	
	//uni-directional many-to-one association to LSMessageType
	@ManyToOne
	@JoinColumn(name="message_Type_Id")
	private LSMessageType lsMessageType;
		
	//uni-directional many-to-one association to LSClientOperation
	@ManyToOne
	@JoinColumn(name="Operation_Id")
	private LSOperation lsOperation;	

	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Column
	private String content;
	
	@Column(name = "is_sent")
	private boolean isSent;
	
	public LSMessage() {
	}
	
	public long getMessage() {
		return messageId;
	}
	
	public LSMessageType getLsMessageType() {
		return lsMessageType;
	}

	public void setLsMessageType(LSMessageType lsMessageType) {
		this.lsMessageType = lsMessageType;
	}	
	
	public LSOperation getLsOperation() {
		return lsOperation;
	}

	public void setLsOperation(LSOperation lsOperation) {
		this.lsOperation = lsOperation;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setIsSent(boolean isSent) {
		this.isSent = isSent;
	}
	
	public boolean getIsSent() {
		return isSent;
	}
}