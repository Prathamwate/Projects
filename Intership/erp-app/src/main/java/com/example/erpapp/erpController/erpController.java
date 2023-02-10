package com.example.erpapp.erpController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erpapp.dto.studentPercentageDto;
import com.example.erpapp.erpModel.Student;
import com.example.erpapp.erpService.ErpsService;

@RestController
@RequestMapping("/api/v1")
public class erpController {
	
	@Autowired
	private ErpsService erps;
	
	@GetMapping("/find-all")
	public List<Student> finadAll() {
		return erps.findAll();
		
	}
	
	@GetMapping("/find-student/{rollNo}")
	public Student  findStudnet(@PathVariable int rollNo) {
		return erps.findStudnet(rollNo);
		
	}
	
	@GetMapping("/topper")
	public List<studentPercentageDto> findTopper() {
		
		return erps.findTopper();
	}
	
	@GetMapping("/least")
	public List<studentPercentageDto> findLeast() {
		
		return erps.findLeast();
	}
	
	
	@GetMapping("/Percentage")
	public List<studentPercentageDto> findPercentage() {
		return erps.findPercentage();
	}

}
