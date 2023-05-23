package com.jpamapping.JpaMapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.jpamapping.JpaMapping.model.Student;
import com.jpamapping.JpaMapping.repository.ICourseRepository;
import com.jpamapping.JpaMapping.repository.IStudentRepository;

@Service
public class StudentService {
       @Autowired
       IStudentRepository iStudentRepository;
       
       @Autowired
       ICourseRepository iCourseRepository;

	public ResponseEntity<String> studentSave(Student student) {
	    Student student1=iStudentRepository.save(student);
	    return new ResponseEntity<String>(student1.toString(),HttpStatus.CREATED);
	}

	public List<Student> getAllStudent() {
		return iStudentRepository.findAll();
	}
       
       
       
}
