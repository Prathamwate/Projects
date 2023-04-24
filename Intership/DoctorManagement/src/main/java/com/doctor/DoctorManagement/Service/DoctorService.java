package com.doctor.DoctorManagement.Service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doctor.DoctorManagement.Model.Doctor;
import com.doctor.DoctorManagement.Repository.IDoctorRepository;
import com.doctor.DoctorManagement.Utils.DoctorUtil;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorUtil doctorUtil;
	
	@Autowired
	private IDoctorRepository iDoctorRepository;
	

	public ResponseEntity<String> createDoctor(String doctor) {
		JSONObject doctorJsonObject=new JSONObject(doctor);	
		JSONObject validate=doctorUtil.validateDoctorData(doctorJsonObject);
		if(validate.isEmpty()) {
			Doctor doctor2=doctorUtil.setDoctor(doctorJsonObject);
			iDoctorRepository.save(doctor2);
			return new ResponseEntity<String>(doctor2.toString(),HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(validate.toString(),HttpStatus.BAD_REQUEST);
		}
		
	
		
	}


	public ResponseEntity<String> deleteDoctor(int id) {
		if(!iDoctorRepository.findById(id).isEmpty()) {
			iDoctorRepository.deleteByDoctor(id);
			return new ResponseEntity<String>("Doctor Deleted ",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Doctor id not found ",HttpStatus.OK);
	}

}
