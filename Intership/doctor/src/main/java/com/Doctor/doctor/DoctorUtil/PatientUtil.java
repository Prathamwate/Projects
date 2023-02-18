package com.Doctor.doctor.DoctorUtil;

import java.sql.Timestamp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Doctor.doctor.model.Doctor;
import com.Doctor.doctor.model.Patient;
import com.Doctor.doctor.repository.IdoctorRepo;

@Component
public class PatientUtil {
	
			@Autowired
			public  IdoctorRepo doctor_repo;
	
	        public Patient setPatient(JSONObject json) {

	        Patient patient = new Patient();

	        patient.setPatientName(json.getString("patientName"));
	        patient.setAge(json.getInt("age"));
	        patient.setPhoneNumber(json.getString("phoneNumber"));
	        patient.setDiseaseType(json.getString("diseaseType"));
	        patient.setGender(json.getString("gender"));

	        Timestamp currTime = new Timestamp(System.currentTimeMillis());
	        patient.setAdmitDate(currTime);

	        int doctorId = json.getInt("doctorId");
	        Doctor doctor = doctor_repo.findById(doctorId).get();
	        System.out.println(doctor);
	        patient.setDoctor(doctor);

	        return patient;


	    }

}
