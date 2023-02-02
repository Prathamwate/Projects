package com.example.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	@RequestMapping("/mess")
	public String meesage() {
		return "Hii Pratham";
	}
	
	@RequestMapping("api/username/{username}")
	public String helloUser(RequestParam username) {
		return "Hellow"+username;
	}
}
