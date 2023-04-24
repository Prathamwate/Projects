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

import com.doctor.DoctorManagement.Service.PatientService;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/createPatient")
	public ResponseEntity<String> createPatient(@RequestBody String patient){
		ResponseEntity<String> msg=patientService.createPatient(patient);
		return msg;
	}
	
	@PostMapping("/getDoctorByCityAndSympton")
	public ResponseEntity<String> getDoctor(@RequestBody String getDocotor){
		ResponseEntity<String> msg=patientService.getDoctor(getDocotor);
		return msg;
	}
	
	@GetMapping("/getPatientById/{id}")
	public ResponseEntity<String> suggestDoctor(@PathVariable int id){
		ResponseEntity<String> msg=patientService.suggestDoctor(id);
		return msg;
	}
	
	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable int id){
      ResponseEntity<String> msg=patientService.deletePatient(id);
	  return msg;
	}
	
}
