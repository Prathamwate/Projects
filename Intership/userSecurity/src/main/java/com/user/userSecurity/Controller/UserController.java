package com.user.userSecurity.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.userSecurity.Model.User;
import com.user.userSecurity.Service.UserService;

import jakarta.validation.Valid;


@RestController
public class UserController  {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("create")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user){
		ResponseEntity<String> msg=userService.createUser(user);
		return msg;
	}
	
	@PostMapping("check")
	public ResponseEntity<String> loginUser(@Valid @RequestBody User user){
		ResponseEntity<String> msg=userService.loginUser(user);
		return msg;
	}
	
}
