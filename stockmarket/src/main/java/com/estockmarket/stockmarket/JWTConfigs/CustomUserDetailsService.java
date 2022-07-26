/*package com.estockmarket.stockmarket.JWTConfigs;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockmarket.stockmarket.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
	User user= (User) userRepo.findByEmail(email);	
	return new User(user.getEmail(),user.getPassword());
	}

	public User loadUser(String email) {
		return userRepo.findByEmail(email);
	}
}*/