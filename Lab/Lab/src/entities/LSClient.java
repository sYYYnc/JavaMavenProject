package entities;

import java.io.Serializable;
import javax.persistence.*;

import data.access.Connection;



@Entity
@Table(name="LS_CLIENT")
public class LSClient implements Serializable {   // GenreicEntity
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "client_Id")
	private long clientId;
	
	@Column
	private String name;

	@Column
	private long nif;
	
	@Column(name = "is_provider")
	private boolean isProvider;	
	
	@Column
	private String address;
	
	public LSClient() {
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null)
			return false;
		return ((LSClient) other).getClientId() == this.getClientId();// Connection.getIdFromEntity(this) == Connection.getIdFromEntity(other);
	}
	
	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getNif() {
		return this.nif;
	}

	public void setNif(long nif) {
		this.nif = nif;
	}
	
	public void setIsProvider(boolean isProvider) {
		this.isProvider = isProvider;
	}
	
	public boolean getIsProvider() {
		return isProvider;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}