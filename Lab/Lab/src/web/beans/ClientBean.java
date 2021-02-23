package web.beans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import data.access.Connection;
import entities.LSClient;
import resources.Em;;

@ManagedBean
@ViewScoped
public class ClientBean {
	
	private LSClient client;
	
	@PostConstruct
	public void init() {
		try {
			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
			if(id == null)
				client = new LSClient();
			else {
				Em em = new Em();
				client = (LSClient) em.em.createNativeQuery("select * from LS_Client where client_Id = :id", LSClient.class)
				.setParameter("id", id)
				.getSingleResult();
				
				em.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void save() throws IOException {
		//insert
		if(client.getClientId() == 0)
			Connection.createNativeQuery("insert into LS_Client (name, nif, is_provider, address) values (:name, :nif, :isProvider, :address)",
				"name", client.getName(),
				"nif", client.getNif(),
				"isProvider", client.getIsProvider(),
				"address", client.getAddress());
		
		//update  
		else
			Connection.createNativeQuery("update LS_Client set name = :name, nif = :nif, address = :address, is_provider = :isProvider where client_Id = :client_Id",
				"client_Id", client.getClientId(),
				"name", client.getName(),
				"nif", client.getNif(),
				"isProvider", client.getIsProvider(),
				"address", client.getAddress());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("clientList.xhtml");
	}
	

	public LSClient getClient() {
		return client;
	}

	public void setClient(LSClient client) {
		this.client = client;
	}

	
	
}
