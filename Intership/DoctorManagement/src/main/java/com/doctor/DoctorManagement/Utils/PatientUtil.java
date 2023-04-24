package com.doctor.DoctorManagement.Utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doctor.DoctorManagement.Model.Doctor;
import com.doctor.DoctorManagement.Model.Patient;
import com.doctor.DoctorManagement.Model.Status;
import com.doctor.DoctorManagement.Repository.IStatus;

@Component
public class PatientUtil {
	@Autowired
	IStatus iStatus;

	public JSONObject isValid(JSONObject patientJsonObject) {
		    JSONObject errorList = new JSONObject();
         
	        if(patientJsonObject.has("city")) {
	        	String Cityname=patientJsonObject.getString("city");
	            if(!Validate.isCityValidforPatient(Cityname)) {
	            	errorList.put("city","city length Should be less than 20");
	            }
	        }
	        else {
	        	 errorList.put("City","city is not present");
	        }

	        if(patientJsonObject.has("patientName")) {
	        	String name=patientJsonObject.getString("patientName");
	            if(!Validate.isNameValid(name)) {
	            	errorList.put("Name","Name Should be at least 3 Character");
	            }
	        }
	        else {
	        	errorList.put("Name","Patient Name  is not Present");
	        }
	        
	        if(patientJsonObject.has("phoneNumber")) {
	           String phone=patientJsonObject.getString("phoneNumber");
	           if(!Validate.isValidPhone(phone)) {
	        	   errorList.put("PhoneNumber","Phone Should be at least 10 Character");
	           }
	        }
	        else {
	        	 errorList.put("PhoneNumber","phoneNumber is not Present");
	        }

	        if(patientJsonObject.has("email")) {
	        	 String email=patientJsonObject.getString("email");
		           if(!Validate.isValidEmail(email)) {
		        	   errorList.put("email","email Should be correct");
		           }
	        }
	        else {
	        	 errorList.put("email","email is not present");
	        }
	        
	       return errorList;
	}

	public Patient setPatient(JSONObject patientJsonObject) {
		ArrayList<String> symptomArrayList=new ArrayList<String>();
		Patient patient=new Patient();
		patient.setCity(patientJsonObject.getString("city"));
		patient.setEmail(patientJsonObject.getString("email"));
		patient.setPatientName(patientJsonObject.getString("patientName"));
		patient.setPhoneNumber(patientJsonObject.getString("phoneNumber"));
		
		if(patientJsonObject.has("symptom")) {
		JSONArray jsonarry=patientJsonObject.getJSONArray("symptom");
        for(int i=0;i<jsonarry.length();i++) {
			System.out.println(jsonarry.getString(i));
			symptomArrayList.add(jsonarry.getString(i));
		}
		}
		Status status=iStatus.findById(1).get();
		patient.setStatus(status);
		patient.setSymptom(symptomArrayList);
		return patient;
	}

	public JSONObject setDoctor(Doctor doctor) {
		 JSONObject jsonObject=new JSONObject();
		 jsonObject.put("DoctorName",doctor.getDoctorName());
		 jsonObject.put("PhoneNumber",doctor.getPhoneNumber());
		 jsonObject.put("Email",doctor.getEmail());
		 jsonObject.put("Specility",doctor.getSpeciality().getSpeciality_type());
		 jsonObject.put("City",doctor.getCity());
		 
		return jsonObject;
	}

}
