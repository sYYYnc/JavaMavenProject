package resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import data.access.Connection;

public class Em {
	public EntityManager em;
	public EntityTransaction tx;
	
	public Em() {
		em = Connection.getEm();
	}
	
	public Em(EntityManager em) {
		this.em = em;
	}

	
	public void reset() {
		close();
		em = Connection.getEm();
	}
	
	public void close() {
		if(tx != null && tx.isActive())
			tx.rollback();
		if(em != null && em.isOpen())
			em.close();
	}
	
	public boolean isOpen() {
		if(em == null)
			return false;
		return em.isOpen();
	}


	public void createNewTransaction() {
		tx = em.getTransaction();
	}
}
