package com.Doctor.doctor.DoctorUtil;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.Doctor.doctor.model.Doctor;

public class DoctorUtil {

	public static Doctor setDoctor (JSONObject json) {
		
        Doctor doctor = new Doctor();
        
        String doctorName = json.getString("doctorName");
        doctor.setDoctorName(doctorName);

        String specializedIn = json.getString("specializedIn");
        doctor.setSpecializedIn(specializedIn);
        
        String exp = json.getString("experience");
        doctor.setExperience(exp);

//        if(json.has("experience")) {
//            int exp = json.getInt("experience");
//            doctor.setExperience(exp);
//        }

        return doctor;
        
}
	
	 public static List<String> validateDoctor(JSONObject json) {

	        List<String> errorList = new ArrayList<>();

	        if(!json.has("doctorId")) {
	            errorList.add("doctorId");
	        }

	        if(!json.has("doctorName")) {
	            errorList.add("doctorName");
	        }
	        
	        if(!json.has("experience")) {
	            errorList.add("experience");
	        }

	        if(!json.has("specializedIn")) {
	            errorList.add("specializedIn");
	        }
	        
	       

	        return errorList;

	    }
}
