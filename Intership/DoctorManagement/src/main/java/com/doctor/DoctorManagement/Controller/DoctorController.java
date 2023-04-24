package com.doctor.DoctorManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.DoctorManagement.Service.DoctorService;

import jakarta.websocket.server.PathParam;



@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/createDoctor")
	public ResponseEntity<String> createDoctor(@RequestBody String  doctor){
		ResponseEntity<String> msg=doctorService.createDoctor(doctor);
		
		return msg;
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id){
      ResponseEntity<String> msg=doctorService.deleteDoctor(id);
		
		return msg;
	}
}
