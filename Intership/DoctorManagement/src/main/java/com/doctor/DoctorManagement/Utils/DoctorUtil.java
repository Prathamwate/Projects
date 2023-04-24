package com.doctor.DoctorManagement.Utils;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doctor.DoctorManagement.Model.Doctor;
import com.doctor.DoctorManagement.Model.Speciality;
import com.doctor.DoctorManagement.Repository.ISpecilityRepository;
import com.doctor.DoctorManagement.Repository.IStatus;

import ch.qos.logback.core.status.Status;

@Component
public class DoctorUtil {
	
	@Autowired
	ISpecilityRepository iSpecilityRepository;
	
	@Autowired
	IStatus iStatus;

	public JSONObject validateDoctorData(JSONObject doctorJsonObject) {
	  	 JSONObject errorList = new JSONObject();
          
	        if(doctorJsonObject.has("city")) {
	        	String Cityname=doctorJsonObject.getString("city");
	            if(!Validate.isCityValid(Cityname)) {
	            	errorList.put("city","city Should be Delhi,Faridabad,Noida");
	            }
	        }
	        else {
	        	 errorList.put("City","city is not present");
	        }

	        if(doctorJsonObject.has("doctorName")) {
	        	String name=doctorJsonObject.getString("doctorName");
	            if(!Validate.isNameValid(name)) {
	            	errorList.put("Name","Name Should be at least 3 Character");
	            }
	        }
	        else {
	        	errorList.put("Name","doctorName is not Present");
	        }
	        
	        if(doctorJsonObject.has("phoneNumber")) {
	           String phone=doctorJsonObject.getString("phoneNumber");
	           if(!Validate.isValidPhone(phone)) {
	        	   errorList.put("PhoneNumber","Phone Should be at least 10 Character");
	           }
	        }
	        else {
	        	 errorList.put("PhoneNumber","phoneNumber is not Present");
	        }

	        if(doctorJsonObject.has("email")) {
	        	 String email=doctorJsonObject.getString("email");
		           if(!Validate.isValidEmail(email)) {
		        	   errorList.put("email","email Should be correct");
		           }
	        }
	        else {
	        	 errorList.put("email","email is not present");
	        }
	        
	       return errorList;
	
	}

	public Doctor setDoctor(JSONObject doctorJsonObject) {
	Doctor doctor=new Doctor();
	doctor.setDoctorName(doctorJsonObject.getString("doctorName"));
	doctor.setEmail(doctorJsonObject.getString("email"));
	doctor.setPhoneNumber(doctorJsonObject.getString("phoneNumber"));
	Speciality speciality=iSpecilityRepository.findById(doctorJsonObject.getInt("speciality")).get();
    doctor.setSpeciality(speciality);
	doctor.setCity(doctorJsonObject.getString("city"));
	com.doctor.DoctorManagement.Model.Status status=iStatus.findById(1).get();
	doctor.setStatus(status);
	
    return doctor;
	}

}
