package com.loginapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginapi.dto.LoginRequestDTO;
import com.loginapi.dto.LoginResponseDTO;
import com.loginapi.service.UserDetailService;
import com.loginapi.util.JwtTokenGenerator;

@CrossOrigin(origins ="localhost:4200")
@RestController
public class LoginController {

	@Autowired
	AuthenticationManager authmanager;

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	JwtTokenGenerator jwtToken;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> authenticate(@RequestBody LoginRequestDTO loginRequestDto) throws Exception {

		try {
			authmanager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequestDto.getUser(), loginRequestDto.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails = userDetailService.loadUserByUsername(loginRequestDto.getUser());
		String token = jwtToken.generateToken(userDetails);
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
}