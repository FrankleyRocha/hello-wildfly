package com.francalino.frankley.hellowildfly.rest;

import com.francalino.frankley.hellowildfly.negocio.IHelloBO;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("hello")
public class HelloRest {
	
	@Inject
	private HelloService srv;
	
	@EJB
	private IHelloBO helloBO;
	
	@GET
	@Path("/msg-rest")
	public String getMessage() {
		return "Hello from REST!";
	}
	
	@GET
	@Path("/msg-ejb-local")
	public String getMessageLocalEJB() {
		return srv.getMessage();
	}
	
	@GET
	@Path("/msg-ejb-remote")
	public String getMessageRemoteEJB() {
		return helloBO.getMessage();
	}

}
