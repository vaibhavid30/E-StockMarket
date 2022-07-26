package com.estockmarket.stockmarket.model;

public class JwtResponse {
	
	private String jwt;
	private String email;
	

	public JwtResponse(String jwt,String email) {
		super();
		this.jwt = jwt;
		this.email=email;
	}

	
	public String getJwt() {
		return jwt;
	}


	public String getEmail() {
		return email;
	}

	}