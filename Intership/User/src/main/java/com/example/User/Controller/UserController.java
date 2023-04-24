package com.example.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Model.User;
import com.example.User.Service.UserService;

import jakarta.annotation.Nullable;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		try {
			Integer id=userService.addUser(user);
			return new ResponseEntity<String>(id.toString(),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Something went Wrong",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getUser")
	public List<User> getUser(@Nullable @RequestParam Integer userId){
		return userService.getUser(userId);
	}
}
