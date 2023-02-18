package com.Doctor.doctor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Doctor.doctor.model.Doctor;
import com.Doctor.doctor.repository.IdoctorRepo;

@Service
public class DoctorService {

	@Autowired
	public IdoctorRepo doctor_repo;

	public Doctor saveDoctor(Doctor doctor) {
		String doctorName = doctor.getDoctorName();
		doctorName = "Dr. " + doctorName;
		doctor.setDoctorName(doctorName);
		return doctor_repo.save(doctor);
	}

	public List<Doctor> getDoctor(String doctorId) {
		List<Doctor> doctorList;
		if (null != doctorId) {
			doctorList = new ArrayList<>();
			doctorList.add(doctor_repo.findById(Integer.parseInt(doctorId)).get());
		} else {
			doctorList = doctor_repo.findAll();
		}
		return doctorList;
	}

	public List<Doctor> getDoctorbyExperience(int experience) {
		List<Doctor> doctorList=doctor_repo.findAll();
		List<Doctor> doctorList1 = new ArrayList<>();
		if(experience!=0) {
		 // doctorList=doctor_repo.findAll();
		  for (Doctor d : doctorList) {
			  int exp=Integer.valueOf(d.getExperience());
			  if(exp>experience)
		     	doctorList1.add(d);
			}
		}
	   return doctorList1;
	}

}
