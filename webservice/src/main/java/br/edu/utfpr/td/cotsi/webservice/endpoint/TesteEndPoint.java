package br.edu.utfpr.td.cotsi.webservice.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.regras.IRegrasBoletim;

@Component
@Path("boletim")
public class TesteEndPoint {

	@Autowired
	IRegrasBoletim regrasBoletim;

	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarTodos() {
		return Response.ok(regrasBoletim.listarBoletins()).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response cadastrarBO(BoletimFurtoVeiculo boletim){
		regrasBoletim.cadastrarBoletim(boletim);
		return Response.ok("Boletim cadastrado...").build();
	}
	

	@PathParam("id") 
	private int id;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getBoById(@PathParam("id") int id){
		try {
			return Response.ok(regrasBoletim.boletimById(id)).build();
		} catch (Exception e) {
			return Response.ok("Boletim não encontrado...  "+ e.getMessage()).build();
		}
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response editBoById(@PathParam("id") int id, BoletimFurtoVeiculo boletim){
		try {
			return Response.ok(regrasBoletim.boletimById(id)).build();
		} catch (Exception e) {
			return Response.ok("Boletim não encontrado...  "+ e.getMessage()).build();
		}
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho3")
	public Response teste3(@QueryParam("var2") String x){
		return Response.ok(String.format("%s foi informado como queryParam", x)).build();
	}
	
	@QueryParam("var2") 
	private String y;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho4")	
	public Response teste4(){
		return Response.ok(String.format("%s = pathParan %s = queryParam ", id, y)).build();
	}
	
	@GET
	@Path("/carregarCliente")
	@Produces({MediaType.APPLICATION_JSON})
	public Response carregarCliente() {
		
		return Response.ok("cliente").build();
	}
	
}

