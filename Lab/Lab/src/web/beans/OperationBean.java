package web.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.primefaces.event.RowEditEvent;

import data.access.Connection;
import entities.LSAgent;
import entities.LSClient;
import entities.LSOperation;
import entities.LSTransactionType;
import resources.Em;;

@ManagedBean
@ViewScoped
public class OperationBean {
	
	private LSOperation operation;
	private List<LSClient> listClient;
	private List<LSAgent> listAgent;
	private List<LSTransactionType> listTransactionType;
	Em em;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		try {
			em = new Em();
						
			Query query = em.em.createNativeQuery("select * from LS_Agent where LS_Agent.agent_Status_Id=1", LSAgent.class);
			listAgent = query.getResultList();
			
			query = em.em.createNativeQuery("select * from LS_Client", LSClient.class);
			listClient = query.getResultList();
			
			query = em.em.createNativeQuery("select * from LS_Transaction_Type", LSTransactionType.class);
			listTransactionType = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void displayMessage() {
        
    }
	
	
	public LSOperation getOperation() {
		return operation;
	}


	public void setOperation(LSOperation operation) {
		this.operation = operation;
	}


	public List<LSClient> getListClient() {
		return listClient;
	}


	public void setListClient(List<LSClient> listClient) {
		this.listClient = listClient;
	}


	public List<LSAgent> getListAgent() {
		return listAgent;
	}


	public void setListAgent(List<LSAgent> listAgent) {
		this.listAgent = listAgent;
	}


	public List<LSTransactionType> getListTransactionType() {
		return listTransactionType;
	}


	public void setListTransactionType(List<LSTransactionType> listTransactionType) {
		this.listTransactionType = listTransactionType;
	}


	

	
}
