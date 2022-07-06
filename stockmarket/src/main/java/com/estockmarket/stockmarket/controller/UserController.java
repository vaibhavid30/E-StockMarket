package com.estockmarket.stockmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.stockmarket.config.CustomUserDetailService;
import com.estockmarket.stockmarket.config.JwtUtil;
import com.estockmarket.stockmarket.model.JwtRequest;
import com.estockmarket.stockmarket.model.JwtResponse;
import com.estockmarket.stockmarket.model.User;
import com.estockmarket.stockmarket.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("market/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailService userDetailsService;


		@PostMapping("/authenticate")
		public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
	
			authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
	
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
	
			final String token = jwtUtil.generateToken(userDetails);
	
			return ResponseEntity.ok(new JwtResponse(token, authenticationRequest.getEmail()));
		}
	
		private void authenticate(String username, String password) throws Exception {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			}catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
		}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/login")
	public User login(@RequestBody User user){
		return userService.getUser(user);
	}


}
