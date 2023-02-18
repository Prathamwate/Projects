package com.Doctor.doctor.controller;



import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Doctor.doctor.DoctorUtil.PatientUtil;
import com.Doctor.doctor.model.Patient;
import com.Doctor.doctor.repository.IdoctorRepo;
import com.Doctor.doctor.service.PatientService;

import jakarta.annotation.Nullable;

@RestController
@RequestMapping("api/patient")
public class PatientController {
	    @Autowired
	    IdoctorRepo doctorRepository;

	    @Autowired
	    PatientService patientservice;
	    
	    @Autowired
	    PatientUtil patientutil ;
	    
	    @PostMapping(value = "/addPatient")
	    public String savePatient(@RequestBody String patientRequest) {

	        JSONObject json = new JSONObject(patientRequest);
	        Patient patient = patientutil.setPatient(json);
	        patientservice.savePatient(patient);

	        return "Saved patient";

	    }
	    
	    @GetMapping(value = "/getPatient")
	    public ResponseEntity<String> getPatients(@Nullable @RequestParam String doctorId,
	                                     @Nullable @RequestParam String patientId) {
										
	    	JSONArray array=patientservice.getPatient(doctorId,patientId);
	    	return new ResponseEntity<>(array.toString(),HttpStatus.OK);
	     }


}
//both null- all patients
//doctorId null- get by patient Id
//patientId null- get all patients been treated by doctorId

//ToDO: get all patients, Get a single patient by patient id, Get all patient who are been treated by doctorId