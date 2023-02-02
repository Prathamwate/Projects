package com.example.My_First_SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrathamController {
	
	
	@RequestMapping("/")
	public String home() 
	{
		
		return "Hellow";
	}

}
