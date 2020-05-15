package fr.eni.formation.banque.rs;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.eni.formation.banque.dao.BanqueDao;
import fr.eni.formation.banque.model.Client;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientApi {

	@Context
	private ServletContext application;
		
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
//	public ClientApi() {}
//	
//	public ClientApi(ServletContext application) {
//		this.application = application;
//	}
	
	@GET
	public List<Client> getAll() {
		BanqueDao dao = (BanqueDao) application.getAttribute("dao");			
		return dao.readClients();
	}

	@GET
	@Path("/{id}")	
	public Client getId(@PathParam("id") long id) {
		BanqueDao dao = (BanqueDao) application.getAttribute("dao");			
		return dao.readClient(id);
	}

	@POST
	public Response postClient(Client client) {
		BanqueDao dao = (BanqueDao) application.getAttribute("dao");			
		dao.createClient(client);
		return Response
				.status(Response.Status.CREATED)
				.entity(client)
				.build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Mon API Rest fonctionne !";
	}
	
	@GET
	@Path("/exemple")
	public Client toto() {
		return new Client("Ainslie","Ben");
	}
	
	
}
