package com.francalino.frankley.hellowildfly.negocio.impl;

import com.francalino.frankley.hellowildfly.negocio.IHelloBO;

import jakarta.ejb.Stateless;

@Stateless
public class HelloBO implements IHelloBO {

	@Override
	public String getMessage() {
		return "Hello from EJB!";
	}

}
