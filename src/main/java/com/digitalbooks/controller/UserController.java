package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.dto.UserDto;
import com.digitalbooks.entity.User;
import com.digitalbooks.service.UserService;


@RestController
@RequestMapping("/api/v1/digitalbooks")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signUp")
	public User createUser(@RequestBody UserDto user) {
		return userService.createUser(user);
	}

	@PostMapping("/signIn")
	public User loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}
	
	
	
	
}
