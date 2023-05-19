package br.edu.utfpr.td.webservice.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.edu.utfpr.td.webservice.modelos.BoletimFurtoVeiculo;
import br.edu.utfpr.td.webservice.regras.IRegrasBoletim;

@Component
@CrossOrigin(origins = "*")
@Path("boletim")
public class BoletimEndPoint {

	@Autowired
	IRegrasBoletim regrasBoletim;

	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarTodos() {
		try {
			return Response.ok(regrasBoletim.listarBoletins()).build();
		} catch (Exception e) {
	        return Response.serverError().entity(e.getMessage()).build();
	    }
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response cadastrarBO(BoletimFurtoVeiculo boletim) {
	    List<String> erros = regrasBoletim.validarBoletim(boletim);
	    if (!erros.isEmpty()) {
	        return Response.status(Response.Status.BAD_REQUEST)
	            .entity(erros)
	            .build();
	    }

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
			BoletimFurtoVeiculo bo = regrasBoletim.boletimById(id);
			return Response.ok(bo).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND)
	                .entity(e.getMessage())
	                .build();
		}
		
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response editBoById(@PathParam("id") int id, BoletimFurtoVeiculo boletim){
		List<String> erros = regrasBoletim.validarBoletim(boletim);
	    if (!erros.isEmpty()) {
	        return Response.status(Response.Status.BAD_REQUEST)
	            .entity(erros)
	            .build();
	    }
		try {
			regrasBoletim.alterarBoletim(id, boletim);
			return Response.ok("Boletim editado...  ").build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND)
	                .entity(e.getMessage())
	                .build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") int id){
		try {
			regrasBoletim.excluirBoletim(id);
			return Response.ok("Boletim deletado...  ").build();
		} catch (Exception e) {
			 return Response.status(Response.Status.NOT_FOUND)
		                .entity(e.getMessage())
		                .build();
		}
	}
	
	@PathParam("cidade") 
	private String cidade;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cidade/{cidade}")	
	public Response filtroPorCidade(@PathParam("cidade") String cidade) {
	    try {
	        List<BoletimFurtoVeiculo> boletins = regrasBoletim.boletinsPorCidade(cidade);
	        if (boletins.isEmpty()) {
	            return Response.status(Response.Status.NOT_FOUND)
	                .entity("Boletins não encontrado para a cidade: " + cidade)
	                .build();
	        }
	        return Response.ok(boletins).build();
	    } catch (Exception e) {
	        return Response.serverError().entity(e.getMessage()).build();
	    }
	}
	
	@PathParam("periodo") 
	private String periodo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/periodo/{periodo}")	
	public Response filtroPorPeriodo(@PathParam("periodo") String periodo) {
	    try {
	        List<BoletimFurtoVeiculo> boletins = regrasBoletim.boletinsPorPeriodo(periodo);
	        if (boletins.isEmpty()) {
	            return Response.status(Response.Status.NOT_FOUND)
	                .entity("Boletins não encontrado para o período: " + periodo)
	                .build();
	        }
	        return Response.ok(boletins).build();
	    } catch (Exception e) {
	        return Response.serverError().entity(e.getMessage()).build();
	    }
	}
}

