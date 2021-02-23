package web.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import data.access.Connection;
import entities.LSClient;
import resources.Em;;

@ManagedBean
@ViewScoped
public class ClientListBean {
	
	private List<LSClient> list;
	Em em;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		em = new Em();
		try {
			list = em.em.createNativeQuery("select * from LS_Client", LSClient.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
		
	public void onRowDelete(LSClient client) {
		list.remove(client);
		Connection.createNativeQuery("delete from LS_Client where client_Id = :id", 
			"id", ""+client.getClientId());
	}

	public List<LSClient> getList() {
		return list;
	}

	public void setList(List<LSClient> list) {
		this.list = list;
	}
	
}
