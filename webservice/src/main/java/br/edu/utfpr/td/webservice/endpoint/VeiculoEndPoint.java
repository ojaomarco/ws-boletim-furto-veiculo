package br.edu.utfpr.td.webservice.endpoint;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.webservice.modelos.Veiculo;
import br.edu.utfpr.td.webservice.regras.IRegrasBoletim;

@Component
@Path("veiculos")
public class VeiculoEndPoint {

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
	
	@PathParam("placa") 
	private String placa;
	
	@PathParam("cor") 
	private String cor;
	
	@PathParam("tipo") 
	private String tipo;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cor/{cor}")
	public Response filtroPorCor(@PathParam("cor") String cor) {
	    try {
	        List<Veiculo> veiculos = regrasBoletim.veiculosPorCor(cor);
	        if (veiculos.isEmpty()) {
	            return Response.status(Response.Status.NOT_FOUND)
	                .entity("Veiculos não encontrados com a cor: " + cor)
	                .build();
	        }
	        return Response.ok(veiculos).build();
	    } catch (Exception e) {
	        return Response.serverError().entity(e.getMessage()).build();
	    }
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("placa/{placa}")
	public Response filtroPorPlaca(@PathParam("placa") String placa) {
	    try {
	        List<Veiculo> veiculos = regrasBoletim.veiculosPorPlaca(placa);
	        if (veiculos.isEmpty()) {
	            return Response.status(Response.Status.NOT_FOUND)
	                .entity("Veiculos não encontrados com a placa: " + placa)
	                .build();
	        }
	        return Response.ok(veiculos).build();
	    } catch (Exception e) {
	        return Response.serverError().entity(e.getMessage()).build();
	    }
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("tipo/{tipo}")
	public Response filtroPorTipo(@PathParam("tipo") String tipo) {
	    try {
	        List<Veiculo> veiculos = regrasBoletim.veiculosPorTipo(tipo);
	        if (veiculos.isEmpty()) {
	            return Response.status(Response.Status.NOT_FOUND)
	                .entity("Veiculos do tipo " + tipo+" não encontrados" )
	                .build();
	        }
	        return Response.ok(veiculos).build();
	    } catch (Exception e) {
	        return Response.serverError().entity(e.getMessage()).build();
	    }
	}
	


	
}

