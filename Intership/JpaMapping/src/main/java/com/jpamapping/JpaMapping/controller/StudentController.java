package com.jpamapping.JpaMapping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpamapping.JpaMapping.model.Student;
import com.jpamapping.JpaMapping.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<String> studentSave(@RequestBody Student student){
		ResponseEntity<String> msg=studentService.studentSave(student);
		return msg;
	}
	
	@GetMapping("/all")
	public List<Student> getList(){
		return studentService.getAllStudent();
	}
}
