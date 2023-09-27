package com.francalino.frankley.hellowildfly.rest;

import jakarta.ejb.Stateless;

@Stateless
public class HelloService {

	public String createHelloMessage(String name) {
		return "Hello " + name + "!";
	}
	
	public String getMessage() {
		return "Hello from local EJB!";
	}

}