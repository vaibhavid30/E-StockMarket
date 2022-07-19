package com.estockmarket.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.estockmarket.stockmarket.model.User;
import com.estockmarket.stockmarket.repositories.UserRepository;

@Service
public class UserService {

	@Autowired(required = true)
	UserRepository userRepository;

	public User saveUser(@RequestBody User user) throws Exception {
		User newUser = new User();
		User userExistCheck = userRepository.findByEmail(user.getEmail());
		if (userExistCheck != null) {
			throw new Exception("Email Already Exist");
		}
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		return userRepository.save(newUser);
	}

	public User checkUser(String email, String password) throws Exception {
		User userDetails = userRepository.findByEmailAndPassword(email, password);
		if (userDetails != null) {
			return (userRepository.findByEmail(email));
		} else {
			throw new Exception("INVALID_CREDENTIALS");
		}
	}

}