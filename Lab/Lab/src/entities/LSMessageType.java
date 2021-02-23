package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LS_MESSAGE_TYPE")
public class LSMessageType implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "message_Type_Id")
	private long messageTypeId;
	
	@Column
	private String description;

	public LSMessageType() {
	}
	
	public long getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(long messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}