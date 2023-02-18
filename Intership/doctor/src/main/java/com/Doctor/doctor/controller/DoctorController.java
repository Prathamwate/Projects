package com.Doctor.doctor.controller;

import java.util.Arrays;
import java.util.List;

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

import com.Doctor.doctor.DoctorUtil.DoctorUtil;
import com.Doctor.doctor.model.Doctor;
import com.Doctor.doctor.service.DoctorService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import io.micrometer.common.lang.Nullable;

@RestController
@RequestMapping("/api/doctorSite")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@PostMapping(value = "/addDoctor")
	public ResponseEntity<String> saveDoctor(@RequestBody Doctor doctor) {

		JSONObject json = new JSONObject(doctor);

		List<String> validationList = DoctorUtil.validateDoctor(json);
		
		if (validationList.isEmpty()) {

			Doctor doctor1 = DoctorUtil.setDoctor(json);

			doctorService.saveDoctor(doctor1);

			return new ResponseEntity<>("Doctor saved", HttpStatus.CREATED);

		} else {

			Object[] answer = Arrays.copyOf(validationList.toArray(), validationList.size(), String[].class);

			return new ResponseEntity<>("Please pass these mandatory parameters- " + Arrays.toString(answer),
					HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/Doctor")
	public List<Doctor> getDoctor(@Nullable @RequestParam String doctorId) {
		return doctorService.getDoctor(doctorId);
	}

	@GetMapping("/getExperienceDoctor")
	public List<Doctor> getDoctorbyExperience(@Nullable @RequestParam int experience) {
		return doctorService.getDoctorbyExperience(experience);
	}

}
