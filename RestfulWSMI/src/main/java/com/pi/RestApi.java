package com.pi;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/*
 Ici c'est la class dans lequel on cree nos ressources 
 */
@Path("/myservice") //Chemin de tout les ressourcess utilisees
public class RestApi {
	@Autowired
	private CitoyenRepository citoyenRepository;

	//API n°1
	@Path("/citoyens") //l'URI de l'API
	@GET  //API type GET
	@Produces(MediaType.APPLICATION_JSON) //Type de donnee (ici format JSON)
	public List<Citoyen> getCitoyens() {  //La methode
		return citoyenRepository.findAll();
	}
	//API n°2
	@Path("/citoyens/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Citoyen getCitoyens(@PathParam("id") int id) {
		return citoyenRepository.findById(id).get();
	}
	
	//API n°3
	@Path("/citoyens")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) //conversion JAVA --> JSON ou XML
	@Produces(MediaType.APPLICATION_JSON)
	public Citoyen add(Citoyen citoyen) {
		return citoyenRepository.save(citoyen);
	}
	
	//API n°4
	@Path("/citoyens")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean delete(@PathParam("id") int id) {
		Optional<Citoyen> c = citoyenRepository.findById(id);
		if (c.isPresent()){
			citoyenRepository.deleteById(id);
			return true;
		}
		else return false;
	}

}