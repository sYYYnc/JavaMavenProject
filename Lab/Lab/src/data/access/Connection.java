package data.access;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.jboss.logging.Logger;

//import pt.ren.gs.ren_hub.entities.IO;
//import pt.ren.gs.ren_hub.entities.IOable;
import resources.Em;

public final class Connection {
	
	private final static Logger LOG = Logger.getLogger(Connection.class);
	
	@PersistenceUnit(name = "Lab", unitName="Lab")
	private static EntityManagerFactory factory = null;
	
	public synchronized static EntityManager getEm() {
		initialize();
		return factory.createEntityManager(); 
	}

	protected static java.sql.Connection conn;
	public static void initialize() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("Lab");
			
		}
	}
	
	public static Boolean insert(Object obj) {
		return insert(new Em(), obj);
	}
	//teste
	public static Boolean insert(Em em, Object obj) {
		try {
			return insert(em, obj, true);
		} catch (Exception e) {
			LOG.error("Erro no persist",e);
			try {
				//TabelaTesteDAL.insert(em, new TabelaTeste("Erro no persist", "", ZonedDateTime.now()));
			} catch (Exception e1) {
				LOG.error("Erro ",e1 );
			}
			LOG.error("Erro ",e );
			return false;
		}
	}
	
	public static Boolean insert(Em em, Object obj, Boolean processException) throws Exception {
		try {
			EntityTransaction tx = em.em.getTransaction();
			insert(em, tx, obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			em.reset();
			if(processException) {
				LOG.error("Erro no persist",e);
				System.out.println(e.getCause());
				return false;
			} else
				throw e;
		}
	}
	
	public static void insert(Em em, EntityTransaction tx, Object obj) throws Exception {
		if(tx == null)
			tx = em.em.getTransaction();
		
		if(!tx.isActive())
			tx.begin();
		em.em.persist(obj);
	}
	
	public static Boolean update(Object obj) {
		return update(new Em(), obj);
	}
	
	public static Boolean update(Em em, Object obj) {
		try {
			return update(em, obj, true);
		} catch (Exception e) {
			LOG.error("Erro no update",e);
			System.out.println(e.getCause());
			return false;
		}
	}
	
	public static Boolean update(Em em, Object obj, Boolean processException) throws Exception {
		try {
			EntityTransaction tx = em.em.getTransaction();
			update(em, tx, obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			LOG.error("Erro no update",e);
			em.reset();
			if(processException) {
				System.out.println(e.getCause());
				return false;
			} else
				throw e;
		}
	}
	
	public static void update(Em em, EntityTransaction tx, Object obj) throws Exception {
		if(!tx.isActive())
			tx.begin();
		em.em.merge(obj);
	}
	
	public static Boolean remove(Object obj) {
		return remove(new Em(), obj);
	}
	
	public static Boolean remove(Em em, Object obj) {
		try {
			EntityTransaction tx = em.em.getTransaction();
			if(!tx.isActive())
				tx.begin();
			em.em.remove(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			LOG.error("Erro no remove",e);
			System.out.println(e.getCause());
			return false;
		}
	}
	
	public static <T> Boolean persistList(List<T> lst) {
		return persistList(new Em(), lst);
	}
	
	public static <T> Boolean persistList(Em em, List<T> lst) {
		try {
			EntityTransaction tx = em.em.getTransaction();
			for(Object obj : lst)
				insert(em, tx, obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			LOG.error("Erro no persistList",e);
			em.reset();
			System.out.println(e.getCause());
			return false;
		}
	}
	
//	public static <T extends IOable> Boolean persistList(Em em, List<T> lst, IO io) {
//		try {
//			EntityTransaction tx = em.em.getTransaction();
//			for(IOable obj : lst) {
//				obj.setIo(io);
//				insert(em, tx, obj);
//			}
//			tx.commit();
//			return true;
//		} catch (Exception e) {
//			LOG.error("Erro no persistList",e);
//			em.reset();
//			System.out.println(e.getCause());
//			return false;
//		}
//	}
	
	public static <T> Boolean updateList(Em em, List<T> lst) {
		try {
			EntityTransaction tx = em.em.getTransaction();
			for(Object obj : lst)
				update(em, tx, obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			LOG.error("Erro no updateList",e);
			em.reset();
			System.out.println(e.getCause());
			return false;
		}
	}
	
	public static <T> Boolean removeList(Em em, List<T> lst) {
		try {
			EntityTransaction tx = em.em.getTransaction();
			if(!tx.isActive())
				tx.begin();
			for(Object obj : lst)
				em.em.remove(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			LOG.error("Erro!",e);
			em.reset();
			System.out.println(e.getCause());
			return false;
		}
	}

	public static long getIdFromEntity(Object entity) {
		initialize();
		if(entity != null && !(entity instanceof String) && !(entity instanceof Long))
			return (long) factory.getPersistenceUnitUtil().getIdentifier(entity);
		return 0;
	}
	
	public static int createNativeQuery(String query) {
		EntityManager em = getEm();
		try {
			return createNativeQuery(em, query);
		} finally {
			em.close();
		}
	}
	
	public static int createNativeQuery(String query, Object... parameters) {
		EntityManager em = getEm();
		try {
			return createNativeQuery(em, query, parameters);
		} finally {
			em.close();
		}
	}
	
	public static int createNativeQuery(EntityManager em, String query, Object... parameters) {
		return createNativeQuery(em, true, query, parameters);
	}
	
	public static int createNativeQuery(EntityManager em, Boolean commit, String query, Object... parameters) {
		
		int affectedRows = 0;
		EntityTransaction tx = null;
		try {
			if(commit) {
				tx = em.getTransaction();
				tx.begin();
			}
			
			Query q = em.createNativeQuery(query);
			if(parameters != null && parameters.length > 0 && parameters.length % 2 == 0) {
				int i= 0;
				while(i < parameters.length) {
					if(parameters[i] != null && !"".equals(parameters[i]))
						q.setParameter((String) parameters[i], parameters[i+1]);
					i = i + 2;
				}
			}
			affectedRows = q.executeUpdate();
			
			if(commit)
				tx.commit();
		} catch (Exception e) {
			LOG.error("Erro! Commit: "+commit+"\nQuery: \n"+query+"\n Parameter: "+parameters,e);
			affectedRows = -1;
			if(commit && tx != null && tx.isActive())
				tx.rollback();
			System.out.println(e.getCause());
		}
		
		return affectedRows;
    }
	
	public static void close(EntityManager em){
		try{
			if(em != null){
				em.close();
			}
		}catch(Exception e){
			LOG.error("Não foi possivel fechar a ligação.",e);
		}
	}
	
	
}


//package data.access;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public final class Connection {
//	private static EntityManager em = null;
//	private static EntityManagerFactory factory = null;
//	public static EntityManager getEm() {
//		initialize();
//		return em;
//	}
//
//	private static Boolean initialized = false;
//
//	public static void initialize() {
//		if(em == null || !em.isOpen()) {
//			factory = Persistence.createEntityManagerFactory("Lab");
//			if(factory != null)
//				em = factory.createEntityManager();
//		}
//		if (initialized)
//			return;
//		
//		initialized = true;
//	}
//
//	
//}
