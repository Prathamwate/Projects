package com.visitor.visitorCount;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;
	
	@GetMapping("name/{name}/count")
	public HashMap<String, Integer> count(@PathVariable String name) {
		return visitorService.fetchName(name);
	}

}
