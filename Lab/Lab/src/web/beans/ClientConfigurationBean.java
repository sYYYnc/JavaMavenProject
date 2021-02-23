package web.beans;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import data.access.Connection;
import entities.LSClient;
import entities.LSClientConfiguration;
import entities.LSClientStatus;
import resources.Em;;

@ManagedBean
@ViewScoped
public class ClientConfigurationBean {
	
	private LSClientConfiguration clientConfiguration;
	private List<LSClient> listClient;
	private List<LSClientStatus> listClientStatus;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		try {
			Em em = new Em();
			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
			if(id == null) {
				clientConfiguration = new LSClientConfiguration();
				clientConfiguration.setLsClient(new LSClient());
				clientConfiguration.setLsClientStatus(new LSClientStatus());
			} else {
				clientConfiguration = (LSClientConfiguration) em.em.createNativeQuery("select * from LS_Client_Configuration where client_configuration_Id = :id", LSClientConfiguration.class)
				.setParameter("id", id)
				.getSingleResult();
			}
			
			listClient = em.em.createNativeQuery("select * from LS_Client", LSClient.class).getResultList();
			
			listClientStatus = em.em.createNativeQuery("select * from LS_Client_Status", LSClientStatus.class).getResultList();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LocalDateTime newCreationTimestamp(){
		return LocalDateTime.now();
	}
	
	public void save() throws IOException {
		//insert
		if(clientConfiguration.getClientConfigurationId() == 0)
			Connection.createNativeQuery("insert into LS_Client_Configuration (phone_number, client_id, client_status_id, balance, creation_timestamp) values (:phoneNumber, :clientId, :clientStatusId, :balance, :creationTimestamp)",
				"phoneNumber", clientConfiguration.getPhoneNumber(),
				"clientId", clientConfiguration.getLsClient(),
				"clientStatusId", clientConfiguration.getLsClientStatus(),
				"balance", clientConfiguration.getBalance(),
				"creationTimestamp", newCreationTimestamp());
		
		//update  
		else
			Connection.createNativeQuery("update LS_Client_Configuration set phone_number = :phoneNumber, client_id = :clientId, client_status_id = :clientStatusId, balance = :balance where client_configuration_Id = :clientConfigurationId",
				"clientConfigurationId", clientConfiguration.getLsClient().getClientId(),
				"phoneNumber", clientConfiguration.getPhoneNumber(),
				"clientId", clientConfiguration.getLsClient(),
				"clientStatusId", clientConfiguration.getLsClientStatus(),
				"balance", clientConfiguration.getBalance());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("clientConfigurationList.xhtml");
	}
	

	public List<LSClient> getListClient() {
		return listClient;
	}

	public void setListClient(List<LSClient> listClient) {
		this.listClient = listClient;
	}

	public List<LSClientStatus> getListClientStatus() {
		return listClientStatus;
	}

	public void setListClientStatus(List<LSClientStatus> listClientStatus) {
		this.listClientStatus = listClientStatus;
	}

	public LSClientConfiguration getClientConfiguration() {
		return clientConfiguration;
	}

	public void setClientConfiguration(LSClientConfiguration clientConfiguration) {
		this.clientConfiguration = clientConfiguration;
	}
	
}
