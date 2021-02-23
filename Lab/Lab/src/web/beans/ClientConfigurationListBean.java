package web.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import data.access.Connection;
import entities.LSClientConfiguration;
import resources.Em;;

@ManagedBean
@ViewScoped
public class ClientConfigurationListBean {
	
	private List<LSClientConfiguration> list;
	Em em;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		em = new Em();
		try {
			list = em.em.createNativeQuery("select * from LS_Client_Configuration", LSClientConfiguration.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
		
	public void onRowDelete(LSClientConfiguration clientConfiguration) {
		list.remove(clientConfiguration);
		Connection.createNativeQuery("delete from LS_Client_Configuration where client_Configuration_Id = :id", 
			"id", ""+clientConfiguration.getClientConfigurationId());
	}

	public List<LSClientConfiguration> getList() {
		return list;
	}

	public void setList(List<LSClientConfiguration> list) {
		this.list = list;
	}
	
}
