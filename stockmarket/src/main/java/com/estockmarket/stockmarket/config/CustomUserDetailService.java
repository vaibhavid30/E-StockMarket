package com.estockmarket.stockmarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.estockmarket.stockmarket.model.User;
import com.estockmarket.stockmarket.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
    	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
	User user= userRepo.findByEmail(email);	
	return new User(user.getEmail(),user.getPassword());
	}

	public User loadUser(String email) {
		return userRepo.findByEmail(email);
	}
}
