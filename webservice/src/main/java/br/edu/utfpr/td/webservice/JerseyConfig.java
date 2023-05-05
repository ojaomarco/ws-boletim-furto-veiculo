package br.edu.utfpr.td.webservice;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.webservice.endpoint.TesteEndPoint;

@Component
@ApplicationPath("/webservice")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		this.register(RequestContextFilter.class);
		this.register(TesteEndPoint.class);
	}
}