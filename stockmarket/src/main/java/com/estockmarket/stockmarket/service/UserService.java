package com.estockmarket.stockmarket.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.estockmarket.stockmarket.model.JwtRequest;
import com.estockmarket.stockmarket.model.User;
import com.estockmarket.stockmarket.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired(required = true)
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public User saveUser(@RequestBody User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

	public UserDetails checkUser(String email, String password) throws Exception {
		User userdetails = userRepository.findByUsername(email);
		if (bcryptEncoder.matches(password, userdetails.getPassword())){
			return new User(userdetails.getUsername(), userdetails.getPassword());
		}
		else{
			throw new Exception("INVALID_CREDENTIALS");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User userdetails = userRepository.findByUsername(username);
			if (userdetails == null){
				throw new UsernameNotFoundException("INVALID_CREDENTIALS");
			}
			return  new User(userdetails.getUsername(), userdetails.getPassword());
	}
}