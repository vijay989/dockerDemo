package com.loginapi.dto;

public class LoginResponseDTO {

	private String jwtToken;

	public String getJwtToken() {
		return jwtToken; 
	}

	public LoginResponseDTO(String jwtToken) {

		this.jwtToken = jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
