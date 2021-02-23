package rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import data.access.Connection;
import entities.Colaboradores;

@Path("/rest")
public class SimpleRestService {

	
	@GET
	@Path("/colaboradores/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Colaboradores> colaboradores3(
		@QueryParam("nome") String nome,
		@QueryParam("vencimento") String vencimento
	) {
		StringBuilder queryString = new StringBuilder("select * from colaboradores where 1=1");
		if(nome != null)
			queryString.append(" and nome like '%").append(nome).append("%'");
		
		if(vencimento != null)
			queryString.append(" and vencimento = ").append(vencimento);
		
		return Connection.getEm().createNativeQuery(queryString.toString(), Colaboradores.class).getResultList();
	}
	
	@GET
	@Path("/colaboradores/v2/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Colaboradores> colaboradores2(
		@PathParam("nome") String nome
	) {
		StringBuilder queryString = new StringBuilder("select * from colaboradores where 1=1");
		if(nome != null)
			queryString.append(" and nome like '%").append(nome).append("%'");
		
		return Connection.getEm().createNativeQuery(queryString.toString(), Colaboradores.class).getResultList();
	}
	
	@GET
	@Path("/colaboradores/v3")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Colaboradores> colaboradores3(@Context UriInfo ui) {
	    StringBuilder queryString = new StringBuilder("select * from colaboradores where 1=1");
	    
	    for (Entry<String, List<String>> entry : ui.getQueryParameters().entrySet())
	    	queryString.append(" and ").append(entry.getKey()).append("='").append(entry.getValue().get(0)).append("'");
	    
	    return Connection.getEm().createNativeQuery(queryString.toString(), Colaboradores.class).getResultList();
	}
	
	@GET
	@Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
	public String getSomething(@QueryParam("request") String request ,
			 @DefaultValue("1") @QueryParam("version") int version) {

		String response = null;

        try{			
            switch(version){
	            case 1:
	                response = "Response from RESTEasy Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        return response;	
	}

	@POST
	@Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
	public String postSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {

		String response = null;

        try{			
            switch(version){
	            case 1:
	                response = "Response from RESTEasy Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        return response;	
	}

	@PUT
	@Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
	public String putSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {

		String response = null;

        try{			
            switch(version){
	            case 1:
	                response = "Response from RESTEasy Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        return response;	
	}

	@DELETE
	@Path("/ping")
	public void deleteSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {
		
        try{			
            switch(version){
	            case 1:
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}
}
