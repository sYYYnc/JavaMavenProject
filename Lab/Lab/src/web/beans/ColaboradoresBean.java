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
import entities.Colaboradores;
import resources.Em;;

@ManagedBean
@ViewScoped
public class ColaboradoresBean {
	
	private List<Colaboradores> colaboradoresList;
	Em em;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		try {
			em = new Em();
			Query query = em.em.createNativeQuery("select * from colaboradores", Colaboradores.class);
			colaboradoresList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Colaboradores> getColaboradoresList() {
		return colaboradoresList;
	}

	public void setColaboradoresList(List<Colaboradores> colaboradoresList) {
		this.colaboradoresList = colaboradoresList;
	}
	
}
