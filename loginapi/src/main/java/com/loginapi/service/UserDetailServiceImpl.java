package com.loginapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	//@Autowired 
	//LoginService loginService;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User("abc", "abc", new ArrayList());
	}

}
