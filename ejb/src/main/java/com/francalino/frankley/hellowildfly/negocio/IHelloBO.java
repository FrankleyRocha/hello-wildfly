package com.francalino.frankley.hellowildfly.negocio;

import jakarta.ejb.Remote;

@Remote
public interface IHelloBO {
	
	public String getMessage();

}
