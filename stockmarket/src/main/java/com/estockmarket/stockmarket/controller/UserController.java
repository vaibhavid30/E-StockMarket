package com.estockmarket.stockmarket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.stockmarket.model.User;
import com.estockmarket.stockmarket.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/market/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	

	private static final String TOPIC = "kafkaUserTopicCheck";

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		kafkaTemplate.send(TOPIC, user);
		return ResponseEntity.ok(userService.saveUser(user));
	}

	@PostMapping("/login")
	public ResponseEntity<?> checkUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userService.checkUser(user.getEmail(), user.getPassword()));
	}

	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message)
	{
		//kafkaTemplate.send(TOPIC, message);
		return "published successfully";
	}

}
