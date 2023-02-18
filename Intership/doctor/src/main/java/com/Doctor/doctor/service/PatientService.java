package com.Doctor.doctor.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Doctor.doctor.model.Patient;
import com.Doctor.doctor.repository.IpatientRepo;

@Service
public class PatientService {

	@Autowired
	IpatientRepo patientRepo;

	public void savePatient(Patient patient) {
		patientRepo.save(patient);
	}

	public JSONArray getPatient(String doctorId, String patientId) {

		if (doctorId == null && patientId == null) {

			List<Patient> patientList = patientRepo.findAll();

			JSONArray jsonArray = new JSONArray();

			for (Patient p : patientList) {
				JSONObject json = new JSONObject();
				json.put("patientId", p.getPatientId());
				json.put("patient_name", p.getPatientName());
				json.put("age", p.getAge());
				json.put("phone_number", p.getPhoneNumber());
				json.put("disease_type", p.getDiseaseType());
				json.put("gender", p.getGender());
				json.put("admit_date", p.getAdmitDate());
				json.put("doctor_id", p.getDoctor().getDoctorId());
				jsonArray.put(json);

			}
			return jsonArray;
		}

		else if (patientId != null) {
		
			Patient p = patientRepo.findById(Integer.valueOf(patientId)).get();
			JSONArray jsonArray = new JSONArray();

			JSONObject json = new JSONObject();
			json.put("patientId", p.getPatientId());
			json.put("patient_name", p.getPatientName());
			json.put("age", p.getAge());
			json.put("phone_number", p.getPhoneNumber());
			json.put("disease_type", p.getDiseaseType());
			json.put("gender", p.getGender());
			json.put("admit_date", p.getAdmitDate());
			json.put("doctor_id", p.getDoctor().getDoctorId());
			jsonArray.put(json);

			return jsonArray;

		}
		
		else if(doctorId!=null) {
			int doctorId1=Integer.valueOf(doctorId);
			List<Patient> patient=patientRepo.findAll();
			JSONObject json = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(Patient p:patient) {
				if(p.getDoctor().getDoctorId()==doctorId1) {
					json.put("patientId", p.getPatientId());
					json.put("patient_name", p.getPatientName());
					json.put("age", p.getAge());
					json.put("phone_number", p.getPhoneNumber());
					json.put("disease_type", p.getDiseaseType());
					json.put("gender", p.getGender());
					json.put("admit_date", p.getAdmitDate());
					json.put("doctor_id", p.getDoctor().getDoctorId());
					jsonArray.put(json);
				}
				
			}
			return jsonArray;
		}
		
		else {
			JSONArray jsonArray=new JSONArray();
			JSONObject json = new JSONObject();
			json.put("Invalid", false);
			jsonArray.put(json);
			
			return jsonArray;
			
		}

		
	}

}
