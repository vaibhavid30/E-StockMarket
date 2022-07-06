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
	

    public User saveUser(@RequestBody User user) {
		User userSet = new User();
		userSet.setName(user.getName());
		userSet.setEmail(user.getEmail());
		userSet.setPassword(user.getPassword());
		return userRepository.save(userSet);
	}

	public User getUser(@RequestBody User user) {

		String Email = user.getEmail();
		String Password = user.getPassword();

		User userdetails = userRepository.findByEmailAndPassword(Email, Password);
		return userdetails;
	}
}
